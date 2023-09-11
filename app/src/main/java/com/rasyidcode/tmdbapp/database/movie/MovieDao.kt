package com.rasyidcode.tmdbapp.database.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie WHERE fetch_type = :fetchType ORDER BY id ASC")
    fun getMoviesByFetchType(fetchType: MovieFetchType): LiveData<List<MovieEntity>?>

    @Query("SELECT * FROM movie LIMIT 5")
    fun getTheFirstFive(): LiveData<List<MovieEntity?>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity?>?)

}