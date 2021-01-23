package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.androidacademy.util.IResProvider

class MovieListViewModelFactory(private val resProvider: IResProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(resProvider) as T
    }
}