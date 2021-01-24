package com.bignerdranch.android.androidacademy.util

import com.bignerdranch.android.androidacademy.data.Cast
import com.bignerdranch.android.androidacademy.data.Movie

interface IResProvider {
    suspend fun getLoadedMovies(): List<Movie>
    suspend fun getLoadedActors(id: Long): List<Cast>
}