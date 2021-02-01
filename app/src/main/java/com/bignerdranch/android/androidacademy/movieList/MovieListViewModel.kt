package com.bignerdranch.android.androidacademy.movieList

import android.content.Context
import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val resProvider: IResProvider
) : ViewModel() {

    private val _movieListLiveData = MutableLiveData<List<Movie>>()
    val movieListLiveData: LiveData<List<Movie>>
        get() = _movieListLiveData

    fun loadFromDb(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesRep = MoviesRep(context)
            val dbMovies = moviesRep.getAllMovies()
            if (dbMovies.isNotEmpty()) {
                _movieListLiveData.postValue(dbMovies)
            }

            val loadedMovies = resProvider.getLoadedMovies()
            _movieListLiveData.postValue(loadedMovies)
            moviesRep.deleteAllMoviesAndSetNew(loadedMovies)

        }
    }

}