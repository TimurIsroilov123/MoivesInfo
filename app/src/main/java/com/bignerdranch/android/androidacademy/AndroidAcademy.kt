package com.bignerdranch.android.androidacademy

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.bignerdranch.android.androidacademy.data.MovieWorker
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.data.WorkRepository
import com.bignerdranch.android.androidacademy.room.MovieDataBase

class AndroidAcademy : Application() {
    private val workRepository = WorkRepository()

    override fun onCreate() {
        super.onCreate()

        WorkManager.getInstance(this).enqueue(workRepository.request)

        moviesDb = MovieDataBase.create(this)
    }

    companion object {
//        val moviesRep = MoviesRep()

        lateinit var moviesDb: MovieDataBase
    }

}