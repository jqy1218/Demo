package com.lirenqi.roomdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lirenqi.roomdemo.data.Word
import com.lirenqi.roomdemo.repository.WordRepository
import kotlinx.coroutines.launch

/*
* @Date   : 2021/04/25,025
* @Author : LIRENQI
*/
class WordViewModel(private val repository: WordRepository): ViewModel() {
    val  allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch { repository.insert(word) }

}