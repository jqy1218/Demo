package com.lirenqi.roomdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lirenqi.roomdemo.repository.WordRepository
import java.lang.IllegalArgumentException

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}