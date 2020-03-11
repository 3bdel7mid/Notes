package com.example.note

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.note.DataBase.MyDataBase
import com.example.note.DataBase.models.NoteModel
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        Button_Done.setOnClickListener {
            val title:String = Title_TV.text.toString()
            val description:String = description_TV.text.toString()
            val date:String = date_TV.text.toString()
            val note = NoteModel(titleNote = title,description = description,date = date)
            MyDataBase.getInstance(applicationContext)?.notedao()?.addNote(note)
            showsuccessmessage()
        }
    }

    private fun showsuccessmessage() {
        val builder= AlertDialog.Builder(this)
        builder.setMessage(R.string.Note_Created_Successfully)
        builder.setPositiveButton(R.string.ok, DialogInterface.OnClickListener { dialogInterface, i ->
         dialogInterface.dismiss()
            finish()
        })
        builder.setCancelable(false)
        builder.show()
    }
}
