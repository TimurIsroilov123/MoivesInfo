package com.bignerdranch.android.androidacademy

import com.bignerdranch.android.androidacademy.data.Movie

interface OnMovieItemClickListener {
    fun onItemClickShowDetail(movie: Movie)
    fun onItemClickShowList()
}