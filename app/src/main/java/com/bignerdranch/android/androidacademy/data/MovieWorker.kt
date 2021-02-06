package com.bignerdranch.android.androidacademy.data

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.bignerdranch.android.androidacademy.AndroidAcademy.Companion.moviesRep


class MovieWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if (ConnectionChecker.isOnline()) {
            val loadedMovies = moviesRep.loadMovies().results
            if (loadedMovies.isNotEmpty()) {
                moviesRep.deleteAllMoviesAndSetNew(loadedMovies)
                return Result.success()
            }
        }
        return Result.failure()
    }
}