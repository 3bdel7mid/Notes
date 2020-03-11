package com.example.note

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.note.DataBase.MyDataBase

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var noteadapter = NoteAdapter(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Recycler_View.adapter = noteadapter

        fab.setOnClickListener { view ->
            intent=Intent(this@MainActivity,AddNoteActivity::class.java)
            startActivity(intent)
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/
        }
    }
    override fun onStart() {
        super.onStart()
        val data = MyDataBase.getInstance(applicationContext)
            ?.notedao()
            ?.getAllNote()
            noteadapter.ChangeData(data)
    }
}

