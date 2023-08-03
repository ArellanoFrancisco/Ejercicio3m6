package com.example.ejercicio3m6.Model.Modelo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(text: Text)


    @Query("DELETE FROM TABLE_TEXT")
    fun deleteAll()

    @Query("SELECT * FROM  TABLE_TEXT")
    fun getAllText(): LiveData<List<Text>>
}