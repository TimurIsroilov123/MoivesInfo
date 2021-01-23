package com.bignerdranch.android.androidacademy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MovieDetails (
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,


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

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany>,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry>,

    @SerialName("release_date")
    val releaseDate: String,

    val revenue: Long,
    val runtime: Long,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Long
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
