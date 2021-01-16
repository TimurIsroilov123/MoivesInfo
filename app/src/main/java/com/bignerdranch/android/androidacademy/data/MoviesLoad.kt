package com.bignerdranch.android.androidacademy.data

import com.bignerdranch.android.androidacademy.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.Query

class MoviesLoad {

    suspend fun loadMovies(): List<Movie>{
        return RetrofitModule.moviesApiApi.getMovies()
    }
}

private interface MoviesApi {
    @GET("3/movie/popular?language=en-US&page=1")
    suspend fun getMovies(@Query("api_key") key: String = apiKey): List<Movie>
}

private object RetrofitModule {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val moviesApiApi: MoviesApi = retrofit.create()
}

const val apiKey = "71d3014534ead31bdf3e30983069d05f"

const val BASE_URL = "https://api.themoviedb.org/"