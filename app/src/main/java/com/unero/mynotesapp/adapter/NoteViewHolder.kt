package com.unero.mynotesapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.unero.mynotesapp.CustomOnItemClickListener
import com.unero.mynotesapp.NoteAddUpdateActivity
import com.unero.mynotesapp.databinding.ItemNoteBinding
import com.unero.mynotesapp.entity.Note
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemNoteBinding.bind(itemView)
    fun bind(note: Note, activity: Activity) {
        binding.tvItemTitle.text = note.title
        binding.tvItemDate.text = note.date
        binding.tvItemDescription.text = note.description
        binding.cvItemNote.setOnClickListener(CustomOnItemClickListener(adapterPosition, object : CustomOnItemClickListener.OnItemClickCallback {
            override fun onItemClicked(view: View, position: Int) {
                val intent = Intent(activity, NoteAddUpdateActivity::class.java)
                intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position)
                intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, note)
                activity.startActivity(intent)
            }
        }))
    }
}
