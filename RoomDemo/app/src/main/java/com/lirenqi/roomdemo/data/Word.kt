package com.lirenqi.roomdemo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
@Entity(tableName = "word_table")
data class Word(@PrimaryKey  @ColumnInfo(name = "word") val word: String)
