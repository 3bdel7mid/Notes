package com.example.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note.DataBase.models.NoteModel

class NoteAdapter(var notes:List<NoteModel>?):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title : TextView;
        var date : TextView;
        init {
            title=view.findViewById(R.id.title)
            date=view.findViewById(R.id.date)
        }

    }

    fun ChangeData(list: List<NoteModel>?){
        this.notes=list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return notes?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes?.get(position)
        holder.title.setText(note?.titleNote)
        holder.date.setText(note?.date)
    }
}