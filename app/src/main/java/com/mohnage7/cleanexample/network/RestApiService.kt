package com.mohnage7.cleanexample.network

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET


interface RestApiService {
    @GET("posts")
    fun getPosts(): Single<PostsResponse>
}
