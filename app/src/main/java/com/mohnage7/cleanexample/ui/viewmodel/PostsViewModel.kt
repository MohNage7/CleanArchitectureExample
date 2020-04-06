package com.mohnage7.cleanexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mohnage7.cleanexample.ui.model.Post
import com.mohnage7.cleanexample.ui.repository.Repository
import io.reactivex.Observable
import io.reactivex.Single

class PostsViewModel(private val repository: Repository) : ViewModel() {
    fun observePostsChanges(): Single<List<Post>> {
        return repository.getPosts()
    }
}