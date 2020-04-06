package com.mohnage7.cleanexample.ui.repository

import com.mohnage7.cleanexample.db.PostEntity
import com.mohnage7.cleanexample.db.PostsDatabase
import com.mohnage7.cleanexample.network.RestApiService
import com.mohnage7.cleanexample.ui.model.Post
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


class Repository(
    private val restApiService: RestApiService,
    private val postsDatabase: PostsDatabase
) {

//    fun getPosts(): Single<List<Post>> = restApiService.getPosts().map { it.data!! }
//        .onErrorResumeNext { throwable ->
//            return@onErrorResumeNext if (throwable is IOException) {
//                postsDatabase.postDao.getPosts().map { postsList ->
//                    postsList.map { Post(it.content, it.id, it.title) }
//                }
//            } else {
//                Single.error(throwable)
//            }
//        }.doOnSuccess { postsList ->
//            postsDatabase.postDao.insertAll(postsList.map {
//                PostEntity(
//                    it.id,
//                    it.title,
//                    it.body
//                )
//            }
//            )
//        }

    fun getPosts(): Single<List<Post>> = postsDatabase.postDao.getPosts()
        .map { postsList ->
            postsList.map { Post(it.content, it.id, it.title) }
        }
        .filter { it -> it.isNotEmpty() }
        .switchIfEmpty(restApiService.getPosts().subscribeOn(Schedulers.io()).flatMap {
            Single.just(it.data)
        }.doOnSuccess { postsList ->
            postsList?.let {
                postsDatabase.postDao.insertAll(
                    it.map { post ->
                        PostEntity(
                            post.id,
                            post.title,
                            post.body
                        )
                    }
                )
            }
        }).subscribeOn(Schedulers.io())
}

