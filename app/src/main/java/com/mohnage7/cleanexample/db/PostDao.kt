package com.mohnage7.cleanexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mohnage7.cleanexample.ui.model.Post
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface PostDao {
    @Insert
    fun insertAll(postsList: List<PostEntity>)

    @Query("SELECT * from posts")
    fun getPosts(): Single<List<PostEntity>>
}
