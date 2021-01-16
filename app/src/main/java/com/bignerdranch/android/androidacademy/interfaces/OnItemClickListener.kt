package com.bignerdranch.android.androidacademy

import com.bignerdranch.android.androidacademy.data.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
}