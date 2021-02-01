package com.bignerdranch.android.androidacademy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MovieDetails (
    val adult: Boolean? = null,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,


    val budget: Long? = null,
    val genres: List<Genre>,
    val homepage: String? = null,
    val id: Long? = null,

    @SerialName("imdb_id")
    val imdbID: String? = null,

    @SerialName("original_language")
    val originalLanguage: String? = null,

    @SerialName("original_title")
    val originalTitle: String? = null,

    val overview: String? = null,
    val popularity: Double? = null,

    @SerialName("poster_path")
    val posterPath: String? = null,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry>? = null,

    @SerialName("release_date")
    val releaseDate: String? = null,

    val revenue: Long? = null,
    val runtime: Long,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null,

    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,

    @SerialName("vote_average")
    val voteAverage: Double? = null,

    @SerialName("vote_count")
    val voteCount: Long? = null
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
