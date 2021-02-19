package com.bignerdranch.android.androidacademy.util

import com.bignerdranch.android.androidacademy.data.*

class ResProvider: IResProvider {

    override suspend fun getLoadedMovies(): List<Movie> {
        val movies = MoviesRep.loadMovies().results
        val moviesForReturn = mutableListOf<Movie>()
        for (movie in movies) {
            movie.detail = MoviesRep.loadDetails(movie.id)
            moviesForReturn.add(movie)
        }
        return moviesForReturn
    }

    override suspend fun getLoadedActors(id: Long): List<Cast> {
        return MoviesRep.loadActors(id).cast
    }

}
