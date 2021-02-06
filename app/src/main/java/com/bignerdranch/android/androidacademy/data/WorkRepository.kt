package com.bignerdranch.android.androidacademy.data

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import java.util.concurrent.TimeUnit

class WorkRepository {
    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED).build()
//    val request =
//        PeriodicWorkRequestBuilder<MovieWorker>(8, TimeUnit.HOURS)
//            .setConstraints(constraints)
//            .build()

    val request =
        PeriodicWorkRequest.Builder(MovieWorker::class.java, 8, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()
}