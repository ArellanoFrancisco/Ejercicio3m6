package com.example.ejercicio3m6.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicio3m6.Model.Modelo.Text
import com.example.ejercicio3m6.Model.Modelo.TextDataBase
import com.example.ejercicio3m6.Model.TextRepository
import kotlinx.coroutines.launch

class TextViewModel(application: Application): AndroidViewModel(application) {

    private val repository: TextRepository
    val allText : LiveData<List<Text>>

    init {
        val textDao = TextDataBase.getDatabase(application).getTextDao()
        repository = TextRepository(textDao)
        allText = repository.listAllText
    }

    fun insertText(text: Text) = viewModelScope.launch {
        Log.d("TextViewModel", "insertText: Inserting text - ${text.Text}")
        repository.insertText(text)
    }

    fun deleteAll()= viewModelScope.launch {
        Log.d("TextViewModel", "deleteAll: Deleting all texts")
        repository.deleteAllText()
    }



}