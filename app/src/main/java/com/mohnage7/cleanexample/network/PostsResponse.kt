package com.mohnage7.cleanexample.network

import com.google.gson.annotations.SerializedName
import com.mohnage7.cleanexample.ui.model.Post


data class PostsResponse(@SerializedName("posts") val data: List<Post>?)