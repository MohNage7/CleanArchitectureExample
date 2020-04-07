package com.mohnage7.cleanexample.framework.db

import com.mohnage7.data.db.PostLocalDataSource
import com.mohnage7.domain.Post
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PostLocalDataSourceImpl(private val dao: PostDao) : PostLocalDataSource {
    override fun insertAll(postsList: List<Post>) {
        dao.insertAll(postsList.map { PostEntity(it.id, it.title, it.body) })
    }

    override fun getPosts(): Single<List<Post>> {
        return dao.getPosts()
            .flatMap {
                Single.just(it.map { post -> Post(post.content, post.id, post.title) })
            }.subscribeOn(Schedulers.io())
    }
}