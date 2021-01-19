package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.data.Movie
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

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _movieListLiveData.postValue(resProvider.getLoadedMovies())
        }
    }
}