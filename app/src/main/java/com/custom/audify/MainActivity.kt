package com.custom.audify

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.custom.audify.model.Song
import com.custom.audify.viewmodel.SongViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val songs: List<Song> = mutableListOf()
    private lateinit var adapter: SongListAdapter
    private val songViewModel: SongViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = SongListAdapter(songs)
        val rvSongs = findViewById<RecyclerView>(R.id.rvSongList)
        rvSongs.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }

    }

    fun syncSongs(view: View) {
        getAudioFiles()
    }

    //fetch the audio files from storage
    fun getAudioFiles() {
        val contentResolver = contentResolver
        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
        //looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                val title: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val artist: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                val duration: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                val url: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                val modelAudio = Song(title= title, uuid = 1, favourite = false)
                println("title>>>>>>>> $title")
            } while (cursor.moveToNext())
        }

    }
}