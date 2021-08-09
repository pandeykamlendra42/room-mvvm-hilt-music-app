package com.custom.audify.repository

import com.custom.audify.dao.SongDao
import com.custom.audify.model.Song
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepository @Inject constructor(private val songDao: SongDao) {

    suspend fun insertSongs( songs: List<Song>) = songDao.insertSongs(songs)

    fun fetchAllSongs() : Flow<List<Song>> = songDao.fetchAllSongs()
}