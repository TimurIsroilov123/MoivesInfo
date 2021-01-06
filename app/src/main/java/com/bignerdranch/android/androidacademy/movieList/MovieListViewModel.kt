package com.bignerdranch.android.androidacademy.movieList

import android.app.Application
import androidx.activity.ComponentActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.Movie
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieListViewModel(
        private val resProvider: IResProvider
        ): ViewModel() {
    private val _movieListliveData = MutableLiveData<MutableList<Movie>>()
    val movieListliveData: LiveData<MutableList<Movie>>
        get() = _movieListliveData

    fun updateMovie() {
        viewModelScope.launch(IO){
            _movieListliveData.postValue(resProvider.getLoadedMovies())

        }
    }

}