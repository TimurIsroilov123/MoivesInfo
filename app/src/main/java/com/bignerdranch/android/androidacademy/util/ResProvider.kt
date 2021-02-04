package com.bignerdranch.android.androidacademy.util

import android.content.Context
import com.bignerdranch.android.androidacademy.AndroidAcademy.Companion.moviesRep
import com.bignerdranch.android.androidacademy.data.*

class ResProvider(): IResProvider {

    override suspend fun getLoadedMovies(): List<Movie> {
        val movies = moviesRep.loadMovies().results
        val moviesForReturn = mutableListOf<Movie>()
        for (movie in movies) {
            movie.detail = moviesRep.loadDetails(movie.id)
            moviesForReturn.add(movie)
        }
        return moviesForReturn
    }

    override suspend fun getLoadedActors(id: Long): List<Cast> {
        return moviesRep.loadActors(id).cast
    }

}
