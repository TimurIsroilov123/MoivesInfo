package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.Movie
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieListViewModel(
        private val resProvider: IResProvider
) : ViewModel() {
    private val _movieListLiveData = MutableLiveData<MutableList<Movie>>()
    val movieListLiveData: LiveData<MutableList<Movie>>
        get() = _movieListLiveData

    init {
        viewModelScope.launch(IO) {
            _movieListLiveData.postValue(resProvider.getLoadedMovies())
        }
    }
}