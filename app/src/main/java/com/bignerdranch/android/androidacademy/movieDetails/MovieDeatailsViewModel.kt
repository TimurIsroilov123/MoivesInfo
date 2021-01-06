package com.bignerdranch.android.androidacademy.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.androidacademy.FragmentMoviesDetails
import com.bignerdranch.android.androidacademy.Movie
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieDeatailsViewModel(val movie: Movie?): ViewModel() {

    private val _movieDetailsLiveData = MutableLiveData<Movie>()
    val movieDatailsLiveData: LiveData<Movie>
        get() = _movieDetailsLiveData

    fun getPostal(){
        viewModelScope.launch(IO) {
            _movieDetailsLiveData.postValue(movie)
        }
    }
}