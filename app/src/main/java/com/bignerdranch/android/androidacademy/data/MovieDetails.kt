package com.bignerdranch.android.androidacademy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MovieDetails (
    val adult: Boolean = true ,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,

    val budget: Long = 1_000_000,
    val genres: List<Genre>,
    val homepage: String = "unknown",
    val id: Long = 0,

    @SerialName("imdb_id")
    val imdbID: String = "not estimated",

    @SerialName("original_language")
    val originalLanguage: String = "English",

    @SerialName("original_title")
    val originalTitle: String = "unknown",

    val overview: String = "not viewed yet",
    val popularity: Double = 0.0,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry>? = null,

    @SerialName("release_date")
    val releaseDate: String? = "unknown",

    val revenue: Long = 1_000_000,
    val runtime: Long,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null,

    val status: String = "published",
    val tagline: String? = null,
    val title: String = "unknown",
    val video: Boolean = false,

    @SerialName("vote_average")
    val voteAverage: Double = 0.0,

    @SerialName("vote_count")
    val voteCount: Long = 0
): Parcelable

@Serializable
@Parcelize
data class Genre (
    val id: Long,
    val name: String
): Parcelable


@Serializable
@Parcelize
data class ProductionCompany (
    val id: Long,

    @SerialName("logo_path")
    val logoPath: String? = null,

    val name: String,

    @SerialName("origin_country")
    val originCountry: String
): Parcelable

@Serializable
@Parcelize
data class ProductionCountry (
    @SerialName("iso_3166_1")
    val iso3166_1: String,

    val name: String
) : Parcelable

@Serializable
@Parcelize
data class SpokenLanguage (
    @SerialName("iso_639_1")
    val iso639_1: String,

    val name: String
): Parcelable
