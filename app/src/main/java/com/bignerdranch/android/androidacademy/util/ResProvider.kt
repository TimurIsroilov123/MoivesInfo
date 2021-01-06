package com.bignerdranch.android.androidacademy.util

import android.content.Context
import com.bignerdranch.android.androidacademy.Movie
import com.bignerdranch.android.androidacademy.loadMovies

class ResProvider(val context: Context): IResProvider{

    override suspend fun getLoadedMovies(): MutableList<Movie> {
        return loadMovies(context).toMutableList()
    }

}