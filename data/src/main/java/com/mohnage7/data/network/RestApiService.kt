package com.mohnage7.data.network

import io.reactivex.Single
import retrofit2.http.GET


interface RestApiService {
    @GET("posts")
    fun getPosts(): Single<PostsResponse>
}
