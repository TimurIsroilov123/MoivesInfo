package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.AndroidAcademy
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.room.MovieDataBase
import com.bignerdranch.android.androidacademy.room.MovieEntity
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val resProvider: IResProvider
) : ViewModel() {

    var observableMovies: LiveData<List<MovieEntity>> =
        MovieDataBase.create(AndroidAcademy()).movieDao.getMoviesObservable()

    private val _movieListLiveData = MutableLiveData<List<Movie>>()
    val movieListLiveData: LiveData<List<Movie>>
        get() = _movieListLiveData

    fun loadFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            val dbMovies = MoviesRep.getAllMovies()
            if (dbMovies.isNotEmpty()) {
                _movieListLiveData.postValue(dbMovies)
            }

            val loadedMovies = resProvider.getLoadedMovies()
            _movieListLiveData.postValue(loadedMovies)
            MoviesRep.deleteAllMoviesAndSetNew(loadedMovies)

        }
    }
}