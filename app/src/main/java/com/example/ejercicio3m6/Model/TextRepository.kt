package com.example.ejercicio3m6.Model

import androidx.lifecycle.LiveData
import com.example.ejercicio3m6.Model.Modelo.Text
import com.example.ejercicio3m6.Model.Modelo.TextDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TextRepository(private val textDao: TextDao) {

    val listAllText : LiveData<List<Text>> = textDao.getAllText()

    suspend fun insertText(text: Text){
        textDao.insertText(text)
    }

    suspend fun deleteAllText(){
        withContext(Dispatchers.IO) {
        textDao.deleteAll()
    }}

}