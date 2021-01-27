package com.bignerdranch.android.androidacademy.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviesDAO {

    @Query("SELECT * FROM movies ")
    suspend fun getAll(): List<MovieEntity>

    @Insert
    suspend fun insert(movieEntity: MovieEntity)

    @Query("DELETE FROM movies WHERE _id == :id")
    suspend fun deleteById(id: Long)
}