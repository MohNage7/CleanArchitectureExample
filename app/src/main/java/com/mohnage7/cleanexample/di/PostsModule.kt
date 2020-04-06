package com.mohnage7.cleanexample.di

import com.mohnage7.cleanexample.ui.repository.Repository
import com.mohnage7.cleanexample.ui.viewmodel.PostsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postsModule = module {
    //    factory { RoomDataSource(get()) }
    single { Repository(get(), get()) }
    viewModel { PostsViewModel(get()) }
//    factory { GetTimeInRangeUseCase(get()) }
//    factory { WeekUseCase(Calendar.getInstance()) }
}