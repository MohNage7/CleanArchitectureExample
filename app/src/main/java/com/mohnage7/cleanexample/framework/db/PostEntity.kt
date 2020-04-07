package com.mohnage7.cleanexample.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey var id: String,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "content") var content: String? = null
)
