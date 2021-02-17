package com.bignerdranch.android.androidacademy.movieList

import androidx.lifecycle.*
import com.bignerdranch.android.androidacademy.AndroidAcademy.Companion.moviesDb
import com.bignerdranch.android.androidacademy.data.ConnectionChecker
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.data.MoviesRep.toMovie
import com.bignerdranch.android.androidacademy.room.MovieEntity
import com.bignerdranch.android.androidacademy.util.IResProvider
import com.bignerdranch.android.androidacademy.util.ResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val resProvider: ResProvider
) : ViewModel() {

    val observableMovies: LiveData<List<MovieEntity>> =
        moviesDb.movieDao.getMoviesObservable()



    fun loadNewMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            if(ConnectionChecker.isOnline()) {
                val loadedMovies = resProvider.getLoadedMovies()
                MoviesRep.deleteAllMovies()
                MoviesRep.setNewMovies(loadedMovies)
            }
        }
    }
}















//    fun loadNewMovies() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val dbMovies = MoviesRep.getAllMovies()
//            val mappedMovies = mutableListOf<Movie>()
//            if (dbMovies.isNotEmpty()) {
//                dbMovies.forEach {
//                    mappedMovies.add(it.toMovie())
//                }
//                _movieListLiveData.postValue(mappedMovies)
//            }
//            val loadedMovies = resProvider.getLoadedMovies()
//            _movieListLiveData.postValue(loadedMovies)
//        }
//    }

//    fun updateDb() {
//        viewModelScope.launch(Dispatchers.IO) {
//            MoviesRep.deleteAllMovies()
//            MoviesRep.setNewMovies(movieListLiveData.value ?: listOf<Movie>())
//        }
//    }
