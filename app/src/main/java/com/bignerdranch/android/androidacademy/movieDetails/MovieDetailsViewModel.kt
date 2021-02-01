package com.bignerdranch.android.androidacademy.movieDetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.androidacademy.data.Cast
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

    fun loadActors(id: Long, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val moviesRep = MoviesRep(context)
            val actors = moviesRep.getAllActors()
            if (actors.isNotEmpty())
                _actorsLiveData.postValue(actors)

            val loadedCast = resProvider.getLoadedActors(id)
            _actorsLiveData.postValue(loadedCast)
            moviesRep.deleteAllActorsAndSetNew(loadedCast)
        }
    }
}