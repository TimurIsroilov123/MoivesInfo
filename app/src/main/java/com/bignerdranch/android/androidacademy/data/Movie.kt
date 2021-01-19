package com.bignerdranch.android.androidacademy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.*

@Serializable
@Parcelize
data class Сombined(
    val page: Page,
    val actors: List<Actor>,
    val details: MoviesDetails
)

@Serializable
@Parcelize
data class Movie (
    @SerialName("poster_path")
    val posterPath: String?,

    val adult: Boolean,
    val overview: String,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("genre_ids")
    val genreIDS: List<Long>,

    val id: Long,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("original_language")
    val originalLanguage: String,

    val title: String,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    val popularity: Double,

    @SerialName("vote_count")
    val voteCount: Long,

    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double
) : Parcelable


@Serializable
@Parcelize
data class Page(
        @SerialName("page")
        val page: Int,
        @SerialName("results")
        val results: List<Movie>,
        @SerialName("total_results")
        val totalResults: Int,
        @SerialName("total_pages")
        val totalPages: Int
) : Parcelable

@Serializable
@Parcelize
data class Actor (
    val birthday: String,

    @SerialName("known_for_department")
    val knownForDepartment: String,

    val deathday: String? = null,
    val id: Long,
    val name: String,

    @SerialName("also_known_as")
    val alsoKnownAs: List<String>,

    val gender: Long,
    val biography: String,
    val popularity: Double,

    @SerialName("place_of_birth")
    val placeOfBirth: String,

    @SerialName("profile_path")
    val profilePath: String,

    val adult: Boolean,

    @SerialName("imdb_id")
    val imdbID: String,

    val homepage: String? = null
) : Parcelable

@Serializable
data class MoviesDetails (
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("belongs_to_collection")
    val belongsToCollection: Boolean? = null,

    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,

    @SerialName("imdb_id")
    val imdbID: String,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String? = null,

//    @SerialName("production_companies")
//    val productionCompanies: List<ProductionCompany>,
//
//    @SerialName("production_countries")
//    val productionCountries: List<ProductionCountry>,

    @SerialName("release_date")
    val releaseDate: String,

    val revenue: Long,
    val runtime: Long,

//    @SerialName("spoken_languages")
//    val spokenLanguages: List<SpokenLanguage>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Long
)

@Serializable
data class Genre (
    val id: Long,
    val name: String
)

//@Serializable
//data class ProductionCompany (
//    val id: Long,
//
//    @SerialName("logo_path")
//    val logoPath: String? = null,
//
//    val name: String,
//
//    @SerialName("origin_country")
//    val originCountry: String
//)

//@Serializable
//data class ProductionCountry (
//    @SerialName("iso_3166_1")
//    val iso3166_1: String,
//
//    val name: String
//)

//@Serializable
//data class SpokenLanguage (
//    @SerialName("iso_639_1")
//    val iso639_1: String,
//
//    val name: String
//)
