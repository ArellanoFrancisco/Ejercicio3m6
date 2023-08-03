package com.example.ejercicio3m6.Model.Modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Text::class], version = 1)
abstract class TextDataBase : RoomDatabase() {

    abstract fun getTextDao(): TextDao

        companion object {

            @Volatile
            private var INSTANCE: TextDataBase? = null

            fun getDatabase(context: Context): TextDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }

                synchronized(this) {

                    val instance = Room.databaseBuilder(

                        context.applicationContext,

                        TextDataBase::class.java,
                        "TextDatabase"
                    ).build()

                    INSTANCE = instance
                    return instance

                }
            }
        }
    }