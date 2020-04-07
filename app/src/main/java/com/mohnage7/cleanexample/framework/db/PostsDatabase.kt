package com.mohnage7.cleanexample.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATA_BASE_NAME = "clean_db"

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {
    abstract val postDao: PostDao
}