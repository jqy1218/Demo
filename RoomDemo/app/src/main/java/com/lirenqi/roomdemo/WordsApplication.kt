package com.lirenqi.roomdemo

import android.app.Application
import com.lirenqi.roomdemo.data.WordRoomDatabase
import com.lirenqi.roomdemo.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
class WordsApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy {WordRoomDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { WordRepository(database.wordDao()) }

}