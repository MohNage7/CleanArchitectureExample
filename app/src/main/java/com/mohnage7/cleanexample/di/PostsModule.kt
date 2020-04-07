package com.mohnage7.cleanexample.di

import com.mohnage7.cleanexample.framework.db.PostLocalDataSourceImpl
import com.mohnage7.cleanexample.presentation.ui.viewmodel.PostsViewModel
import com.mohnage7.data.Repository
import com.mohnage7.usecase.GetPostsUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postsModule = module {
    single { PostLocalDataSourceImpl(get()) }
    single { GetPostsUseCase(get()) }
    single { Repository(get(), get<PostLocalDataSourceImpl>()) }
    viewModel { PostsViewModel(get()) }
}