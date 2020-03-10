package com.example.note.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.note.DataBase.daos.NoteDao
import com.example.note.DataBase.models.NoteModel

@Database(entities = arrayOf(NoteModel::class),exportSchema = false,version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun notedao():NoteDao
    companion object{
        var myDataBaseInstance:MyDataBase?=null
        fun getInstance(context:Context):MyDataBase?{
            if (myDataBaseInstance==null){
                myDataBaseInstance= Room.databaseBuilder(context,
                    MyDataBase::class.java,"NoteDataBase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return myDataBaseInstance
        }
    }
}