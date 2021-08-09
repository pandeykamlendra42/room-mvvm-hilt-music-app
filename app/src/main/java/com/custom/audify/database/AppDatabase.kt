package com.custom.audify.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.custom.audify.dao.SongDao
import com.custom.audify.model.Song

@Database(entities = [Song::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun songDao(): SongDao
}