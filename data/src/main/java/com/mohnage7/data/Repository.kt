package com.mohnage7.data

import com.mohnage7.data.db.PostLocalDataSource
import com.mohnage7.data.network.RestApiService
import com.mohnage7.domain.Post
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class Repository(
    private val restApiService: RestApiService,
    private val dataSource: PostLocalDataSource
) {
    fun getPosts(): Single<List<Post>> = dataSource.getPosts()
        .filter { it -> it.isNotEmpty() }
        .switchIfEmpty(restApiService.getPosts().subscribeOn(Schedulers.io()).flatMap {
            Single.just(it.data)
        }.doOnSuccess { postsList ->
            postsList?.let {
                dataSource.insertAll(it)
            }
        }).subscribeOn(Schedulers.io())
}

