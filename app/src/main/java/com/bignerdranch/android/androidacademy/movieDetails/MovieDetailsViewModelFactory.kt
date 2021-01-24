package com.bignerdranch.android.androidacademy.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.androidacademy.util.IResProvider
import com.bignerdranch.android.androidacademy.util.ResProvider

class MovieDetailsViewModelFactory(private val resProvider: IResProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(resProvider) as T
    }
}