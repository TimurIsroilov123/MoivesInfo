package com.bignerdranch.android.androidacademy.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bignerdranch.android.androidacademy.util.ResProvider


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val loadedMovies: List<Movie> = ResProvider().getLoadedMovies()
        return if (loadedMovies.isNotEmpty()) {
            MoviesRep.deleteAllMovies()
            MoviesRep.setNewMovies(loadedMovies)
            Result.success()
        } else
            Result.failure()

    }
}