package com.bignerdranch.android.androidacademy.util

import com.bignerdranch.android.androidacademy.data.Page

interface IResProvider {
    suspend fun getLoadedMovies(): Page
}