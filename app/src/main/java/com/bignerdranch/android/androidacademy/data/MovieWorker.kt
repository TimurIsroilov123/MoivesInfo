package com.bignerdranch.android.androidacademy.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            val loadedMovies:List<Movie> = MoviesRep.loadMovies().results
            loadedMovies.let {  MoviesRep.deleteAllMoviesAndSetNew(loadedMovies) }
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }

}