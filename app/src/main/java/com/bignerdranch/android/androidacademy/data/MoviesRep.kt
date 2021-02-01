package com.bignerdranch.android.androidacademy.data

import android.content.Context
import com.bignerdranch.android.androidacademy.room.ActorEntity
import com.bignerdranch.android.androidacademy.room.ActorsDataBase
import com.bignerdranch.android.androidacademy.room.MovieDataBase
import com.bignerdranch.android.androidacademy.room.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class MoviesRep(context: Context) {

    private val moviesDb = MovieDataBase.create(context)
    private val actorsDb = ActorsDataBase.create(context)

    suspend fun loadMovies(): Page {
        return RetrofitModule().moviesApi.getMovies()
    }

    suspend fun loadDetails(id: Long): MovieDetails {
        return RetrofitModule().moviesApi.getMovieDetails(id)
    }

    suspend fun loadActors(id: Long): Credit {
        return RetrofitModule().moviesApi.getActors(id)
    }

    suspend fun getAllMovies(): List<Movie> = withContext(Dispatchers.IO) {
        moviesDb.movieDao.getAll().map { toMovie(it) }
    }

    suspend fun addNewAndGetUpdated(movie: Movie): List<Movie> = withContext(Dispatchers.IO) {
        moviesDb.movieDao.insert(toMovieEntity(movie))
        getAllMovies()
    }

    suspend fun deleteById(id: Long): List<Movie> = withContext(Dispatchers.IO) {
        moviesDb.movieDao.deleteById(id)
        getAllMovies()
    }

    suspend fun deleteAllMoviesAndSetNew(movies: List<Movie>) = withContext(Dispatchers.IO) {
        moviesDb.movieDao.deleteAll()
        for (movie in movies) {
            moviesDb.movieDao.insert(toMovieEntity(movie))
        }
    }

    suspend fun getAllActors(): List<Cast> = withContext(Dispatchers.IO) {
        actorsDb.actorsDAO.getAll().map { toCast(it) }
    }

    suspend fun deleteAllActorsAndSetNew(casts: List<Cast>) = withContext(Dispatchers.IO) {
        actorsDb.actorsDAO.deleteAll()
        for (actor in casts)
            actorsDb.actorsDAO.insert(toActorEntity(actor))
    }


    private fun toMovie(entity: MovieEntity) = Movie(
        id = entity.id,
        adult = entity.adult,
        backdropPath = entity.backdropPath,
        genreIDS = listOf(),
        overview = entity.overview,
        title = entity.title,
        popularity = entity.popularity,
        voteCount = entity.voteCount,
        voteAverage = entity.voteAverage,
        posterPath = entity.posterPath,
        releaseDate = "",
        originalTitle = "",
        originalLanguage = "",
        video = false,
        detail = MovieDetails(
            runtime = entity.runtime,
            genres = entity.genres.split(", ").map { Genre(id = 1, name = it) }
        )
    )

    private fun toMovieEntity(movie: Movie) = MovieEntity(
        posterPath = movie.posterPath!!,
        adult = movie.adult,
        overview = movie.overview,
        genres = movie.detail!!.genres.joinToString { it.name },
        id = movie.id,
        title = movie.title,
        backdropPath = movie.backdropPath,
        popularity = movie.popularity,
        voteCount = movie.voteCount,
        voteAverage = movie.voteAverage,
        runtime = movie.detail!!.runtime,
    )

    private fun toActorEntity(cast: Cast) = ActorEntity(
        id = cast.id,
        name = cast.name,
        profilePath = cast.profilePath ?: ""
    )

    private fun toCast(entity: ActorEntity) = Cast(
        id = entity.id,
        name = entity.name,
        profilePath = entity.profilePath
    )

}

interface MoviesApi {
    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMovies(@Query("api_key") key: String = apiKey): Page

    @GET("movie/{movie_id}?language=en-US")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Long,
        @Query("api_key") key: String = apiKey
    ): MovieDetails

    @GET("movie/{movie_id}/credits?language=en-US")
    suspend fun getActors(
        @Path("movie_id") movieId: Long,
        @Query("api_key") key: String = apiKey
    ): Credit
}


const val apiKey = "71d3014534ead31bdf3e30983069d05f"
const val BASE_URL = "https://api.themoviedb.org/3/"