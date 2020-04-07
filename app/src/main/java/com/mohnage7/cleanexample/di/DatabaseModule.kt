package com.mohnage7.cleanexample.di

import androidx.room.Room
import com.mohnage7.cleanexample.db.DATA_BASE_NAME
import com.mohnage7.cleanexample.db.PostsDatabase
import org.koin.dsl.module

val dataBaseModule = module {
    single { Room.databaseBuilder(get(), PostsDatabase::class.java, DATA_BASE_NAME).build() }
    single { get<PostsDatabase>().postDao }
}