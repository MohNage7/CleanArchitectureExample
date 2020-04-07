package com.mohnage7.cleanexample.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface PostDao {
    @Insert
    fun insertAll(postsList: List<PostEntity>)

    @Query("SELECT * from posts")
    fun getPosts(): Single<List<PostEntity>>
}
