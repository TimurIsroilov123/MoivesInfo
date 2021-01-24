package com.bignerdranch.android.androidacademy.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.androidacademy.data.Cast
import com.bignerdranch.android.androidacademy.util.IResProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val resProvider: IResProvider
) : ViewModel() {
    private val _actorsLiveData = MutableLiveData<List<Cast>>()
    val actorsLiveData: LiveData<List<Cast>>
        get() = _actorsLiveData

    fun loadActors(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _actorsLiveData.postValue(resProvider.getLoadedActors(id))
        }
    }
}