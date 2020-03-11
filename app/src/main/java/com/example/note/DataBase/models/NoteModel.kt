package com.example.note.DataBase.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteModel(
    @ColumnInfo
    var titleNote : String,
    @ColumnInfo
    var description : String,
    @ColumnInfo
    var date : String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int?=null
}