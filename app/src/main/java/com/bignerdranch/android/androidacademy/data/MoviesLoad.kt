package com.bignerdranch.android.androidacademy.data

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.Path
import retrofit2.http.Query

class MoviesLoad {
    suspend fun loadMovies(): Page {
        return RetrofitModule.moviesApi.getMovies()
    }

    suspend fun loadDetails(id: Long): MovieDetails {
        return RetrofitModule.moviesApi.getMovieDetails(id)
    }
}

private interface MoviesApi {
    @GET("3/movie/popular?language=en-US&page=1")
    suspend fun getMovies(@Query("api_key") key: String = apiKey): Page
//
//    @GET("3/movies/details&append_to_response=person")
//    suspend fun getMoviesDetails(@Query("api_key") key: String = apiKey): MovieDetails

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Long,
        @Query("api_key") key: String = apiKey
    ): MovieDetails
}

private object RetrofitModule {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val moviesApi: MoviesApi = retrofit.create()
}

const val apiKey = "71d3014534ead31bdf3e30983069d05f"

const val BASE_URL = "https://api.themoviedb.org/"