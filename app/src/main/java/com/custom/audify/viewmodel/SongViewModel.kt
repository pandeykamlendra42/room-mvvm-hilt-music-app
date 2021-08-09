package com.custom.audify.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.custom.audify.model.Song
import com.custom.audify.repository.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class SongViewModel @ViewModelInject constructor(private val repository: SongRepository): ViewModel() {

    fun insertSongs(songs: List<Song>) = viewModelScope.launch {
        repository.insertSongs(songs);
    }
    val songs = flow<LiveData<List<Song>>> {
        val songs = repository.fetchAllSongs()
//        emit(songs)
    }.flowOn(Dispatchers.IO)
}