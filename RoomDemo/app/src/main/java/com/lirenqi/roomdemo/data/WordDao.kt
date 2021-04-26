package com.lirenqi.roomdemo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteWord(word: Word)

}