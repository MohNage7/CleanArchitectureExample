package com.mohnage7.usecase

import com.mohnage7.data.Repository
import com.mohnage7.domain.Post
import io.reactivex.Single

class GetPostsUseCase(private val repository: Repository) {
    operator fun invoke(): Single<List<Post>> = repository.getPosts()
}