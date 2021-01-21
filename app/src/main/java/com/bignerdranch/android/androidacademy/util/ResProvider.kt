package com.bignerdranch.android.androidacademy.util

import android.content.Context
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MovieDetails
import com.bignerdranch.android.androidacademy.data.Page
import com.bignerdranch.android.androidacademy.data.MoviesLoad

class ResProvider(val context: Context) : IResProvider {

    override suspend fun getLoadedMovies(): Page {
        return MoviesLoad().loadMovies()
    }

    override suspend fun getDetails(movies: List<Movie>): List<MovieDetails> {
        val allDetails: MutableList<MovieDetails> = mutableListOf()
        for (i in movies) {
            allDetails.add(MoviesLoad().loadDetails(i.id))
        }
        return allDetails
    }
}