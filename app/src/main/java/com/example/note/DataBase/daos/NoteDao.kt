package com.example.note.DataBase.daos

import androidx.room.*
import com.example.note.DataBase.models.NoteModel

@Dao
interface NoteDao {
    @Insert
    fun addNote(note:NoteModel)
    @Delete
    fun deleteNote(note:NoteModel)
    @Update
    fun updateNote(note:NoteModel)

    @Query("delete from NoteModel where id= :id ")
    fun deleteNoteById(id:Int)
    @Query("select * from Notemodel")
    fun getAllNote():List<NoteModel>
    @Query("select * from NoteModel where description like :word")
    fun searchNotesByDescription(word:String):List<NoteModel>


}