package com.bignerdranch.android.androidacademy.movieDetails

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.androidacademy.AndroidAcademy
import com.bignerdranch.android.androidacademy.data.Cast
import com.bignerdranch.android.androidacademy.data.ConnectionChecker
import com.bignerdranch.android.androidacademy.data.MoviesRep
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val resProvider: IResProvider
) : ViewModel() {
    private val _actorsLiveData = MutableLiveData<List<Cast>>()
    val actorsLiveData: LiveData<List<Cast>>
        get() = _actorsLiveData

    fun loadActors(id: Long, movieTitle: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val actors = MoviesRep.getActorsByMovieTitle(movieTitle)
            if (actors.isNotEmpty())
                _actorsLiveData.postValue(actors)

            if (ConnectionChecker.isOnline()) {
                val loadedCast = resProvider.getLoadedActors(id)
                Log.i("MovieName", loadedCast[0].name)
                _actorsLiveData.postValue(loadedCast)
                MoviesRep.deleteAllActorsAndSetNew(loadedCast)
            }
        }
    }
}