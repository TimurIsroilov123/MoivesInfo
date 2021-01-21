package com.bignerdranch.android.androidacademy.util

import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MovieDetails
import com.bignerdranch.android.androidacademy.data.Page

interface IResProvider {
    suspend fun getLoadedMovies(): Page
    suspend fun getDetails(movies: List<Movie>): List<MovieDetails>
}