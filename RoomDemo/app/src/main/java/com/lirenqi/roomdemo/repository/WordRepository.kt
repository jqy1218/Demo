package com.lirenqi.roomdemo.repository

import androidx.annotation.WorkerThread
import com.lirenqi.roomdemo.data.Word
import com.lirenqi.roomdemo.data.WordDao
import kotlinx.coroutines.flow.Flow

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}