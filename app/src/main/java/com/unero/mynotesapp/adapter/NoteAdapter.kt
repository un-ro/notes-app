package com.unero.mynotesapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unero.mynotesapp.CustomOnItemClickListener
import com.unero.mynotesapp.entity.Note
import com.unero.mynotesapp.NoteAddUpdateActivity
import com.unero.mynotesapp.R
import com.unero.mynotesapp.databinding.ItemNoteBinding
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class NoteAdapter(activity: Activity) : RecyclerView.Adapter<NoteViewHolder>() {

    var ss = activity

    var listNotes = ArrayList<Note>()
        set(listNotes) {
            if (listNotes.size > 0) {
                this.listNotes.clear()
            }
            this.listNotes.addAll(listNotes)

            notifyDataSetChanged()
        }

    fun addItem(note: Note) {
        this.listNotes.add(note)
        notifyItemInserted(this.listNotes.size - 1)
    }

    fun updateItem(position: Int, note: Note) {
        this.listNotes[position] = note
        notifyItemChanged(position, note)
    }

    fun removeItem(position: Int) {
        this.listNotes.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.listNotes.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position], ss)
    }

    override fun getItemCount(): Int = this.listNotes.size
}