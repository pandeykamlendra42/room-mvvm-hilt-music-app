package com.custom.audify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.custom.audify.model.Song

class SongListAdapter( private val songs: List<Song>): RecyclerView.Adapter<SongListAdapter.SongViewHolder>()  {

    class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
         val view =  LayoutInflater.from(parent.context).inflate(
             R.layout.song_item_layout, parent,false
         )
        return  SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
         val title = holder.itemView.findViewById<TextView>(R.id.tvTitle)
    }

    override fun getItemCount(): Int = songs.size
}