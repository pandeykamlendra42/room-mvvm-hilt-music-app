package com.custom.audify.module

import android.content.Context
import androidx.room.Room
import com.custom.audify.dao.SongDao
import com.custom.audify.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "songs")
            .build()

    @Provides
    fun provideSongDao(database: AppDatabase): SongDao =
        database.songDao()
}