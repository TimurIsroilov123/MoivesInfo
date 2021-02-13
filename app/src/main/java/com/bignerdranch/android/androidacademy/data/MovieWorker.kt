package com.bignerdranch.android.androidacademy.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val loadedMovies: List<Movie> = MoviesRep.loadMovies().results
        return if (loadedMovies.isNotEmpty()) {
            MoviesRep.deleteAllMoviesAndSetNew(loadedMovies)
            Result.success()
        } else
            Result.failure()

    }
}