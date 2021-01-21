package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MovieDetails
import com.bignerdranch.android.androidacademy.data.Page
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val resProvider: IResProvider
) : ViewModel() {
    private val _movieListLiveData = MutableLiveData<Page>()
    val movieListLiveData: LiveData<Page>
        get() = _movieListLiveData

    private val _detailsLiveData = MutableLiveData<List<MovieDetails>>()
    val detailsLiveData: LiveData<List<MovieDetails>>
        get() = _detailsLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _movieListLiveData.postValue(resProvider.getLoadedMovies())
        }
    }

    fun loadDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            _detailsLiveData.postValue(resProvider.getDetails(movieListLiveData.value!!.results))
        }
    }
}