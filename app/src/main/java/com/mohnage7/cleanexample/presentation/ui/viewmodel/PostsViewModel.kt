package com.mohnage7.cleanexample.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mohnage7.domain.Post
import com.mohnage7.usecase.GetPostsUseCase
import io.reactivex.Single

class PostsViewModel(private val getPostUseCase: GetPostsUseCase) : ViewModel() {
    fun observePostsChanges(): Single<List<Post>> {
        return getPostUseCase.invoke()
    }
}