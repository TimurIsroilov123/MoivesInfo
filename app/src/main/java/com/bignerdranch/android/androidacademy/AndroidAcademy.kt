package com.bignerdranch.android.androidacademy

import android.app.Application
import androidx.work.WorkManager
import com.bignerdranch.android.androidacademy.data.WorkRepository
import com.bignerdranch.android.androidacademy.room.MovieDataBase

class AndroidAcademy : Application() {
    private val workRepository : WorkRepository by lazy { WorkRepository() }

    override fun onCreate() {
        super.onCreate()

        WorkManager.getInstance(this).enqueue(workRepository.request)

        moviesDb = MovieDataBase.create(this)
    }

    companion object {

        lateinit var moviesDb: MovieDataBase
    }

}