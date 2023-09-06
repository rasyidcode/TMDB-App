package com.rasyidcode.tmdbapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rasyidcode.tmdbapp.database.movie.MovieDao
import com.rasyidcode.tmdbapp.database.movie.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = true)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}