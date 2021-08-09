package com.custom.audify.dao

import androidx.room.*
import com.custom.audify.model.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<Song>)

    @Update
    suspend fun update(songs: Song)

    @Query("Select * FROM song")
    fun fetchAllSongs(): Flow<List<Song>>
}