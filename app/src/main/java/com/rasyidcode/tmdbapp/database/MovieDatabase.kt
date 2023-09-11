package com.rasyidcode.tmdbapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rasyidcode.tmdbapp.database.movie.MovieDao
import com.rasyidcode.tmdbapp.database.movie.MovieEntity

@Database(entities = [MovieEntity::class], version = 2, exportSchema = true)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}