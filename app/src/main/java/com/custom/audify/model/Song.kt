package com.custom.audify.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song (
    @PrimaryKey(autoGenerate = true)
    val uuid: Int, val title: String, val favourite: Boolean)