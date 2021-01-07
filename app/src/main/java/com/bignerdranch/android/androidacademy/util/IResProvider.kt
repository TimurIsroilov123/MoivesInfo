package com.bignerdranch.android.androidacademy.util

import com.bignerdranch.android.androidacademy.Movie

interface IResProvider {
    suspend fun getLoadedMovies(): MutableList<Movie>
}