package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.androidacademy.util.IResProvider
import com.bignerdranch.android.androidacademy.util.ResProvider

class MovieListViewModelFactory(private val resProvider: ResProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(resProvider) as T
    }
}