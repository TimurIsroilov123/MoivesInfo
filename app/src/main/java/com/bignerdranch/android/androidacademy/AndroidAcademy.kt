package com.bignerdranch.android.androidacademy

import android.app.Application
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.room.MovieDataBase

class AndroidAcademy: Application() {

    override fun onCreate() {
        super.onCreate()
        moviesDb = MovieDataBase.create(this)
    }

    companion object {
        val moviesRep = MoviesRep()

        lateinit var moviesDb: MovieDataBase //= MovieDataBase.create()
    }
}