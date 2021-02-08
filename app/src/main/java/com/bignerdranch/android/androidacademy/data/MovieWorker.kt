package com.bignerdranch.android.androidacademy.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        for (attempt in 0..10) {
            Thread.sleep(1000)
            if (ConnectionChecker.isOnline()) {
                val loadedMovies = MoviesRep.loadMovies().results
                if (loadedMovies.isNotEmpty()) {
                    MoviesRep.deleteAllMoviesAndSetNew(loadedMovies)
                    return Result.success()
                }
            }
        }
        return Result.failure()
    }
}