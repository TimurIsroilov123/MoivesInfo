package com.bignerdranch.android.androidacademy.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        try {
            val loadedMovies:List<Movie> = MoviesRep.loadMovies().results

                loadedMovies.let {  MoviesRep.deleteAllMoviesAndSetNew(loadedMovies) }
                return Result.success()

        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure()
        }
        return Result.failure()
    }

}