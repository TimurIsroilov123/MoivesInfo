package com.bignerdranch.android.androidacademy.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.androidacademy.data.Movie

@Dao
interface MoviesDAO {

    @Query("SELECT * FROM movies ")
    suspend fun getAll(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieEntity: MovieEntity)

    @Query("DELETE FROM movies WHERE id == :id")
    suspend fun deleteById(id: Long)

    @Query("Delete From movies")
    suspend fun deleteAll()

    @Query("Select * from movies")
    fun getMoviesObservable(): LiveData<List<MovieEntity>>
}

