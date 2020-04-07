package com.mohnage7.data.network

import com.google.gson.annotations.SerializedName


data class PostsResponse(@SerializedName("posts") val data: List<com.mohnage7.domain.Post>?)