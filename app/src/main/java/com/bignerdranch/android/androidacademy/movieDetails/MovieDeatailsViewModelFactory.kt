package com.bignerdranch.android.androidacademy.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.androidacademy.Movie

class MovieDeatailsViewModelFactory(private val movie: Movie?): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDeatailsViewModel(movie) as T
    }
}