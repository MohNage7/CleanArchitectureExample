package com.mohnage7.data.db

import com.mohnage7.domain.Post
import io.reactivex.Single

interface PostLocalDataSource {
    fun insertAll(postsList: List<Post>)
    fun getPosts(): Single<List<Post>>
}