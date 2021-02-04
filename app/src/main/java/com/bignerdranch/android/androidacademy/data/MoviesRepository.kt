package com.bignerdranch.android.androidacademy.data

import com.bignerdranch.android.androidacademy.room.ActorEntity
import com.bignerdranch.android.androidacademy.room.MovieEntity

interface MoviesRepository {
    suspend fun getAllMovies(): List<Movie>

    suspend fun deleteAllMoviesAndSetNew(movies: List<Movie>)

    suspend fun getAllActors(): List<Cast>

    suspend fun deleteAllActorsAndSetNew(casts: List<Cast>)

    fun toMovie(entity: MovieEntity): Movie

    fun toMovieEntity(movie: Movie): MovieEntity

    fun toActorEntity(cast: Cast): ActorEntity

    fun toCast(entity: ActorEntity): Cast
}