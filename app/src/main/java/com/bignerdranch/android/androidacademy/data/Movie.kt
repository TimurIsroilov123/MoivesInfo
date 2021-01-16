package com.bignerdranch.android.androidacademy.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.*

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


//@Serializable
//@Parcelize
//data class Movie(
//        @SerialName("page")
//        val page: Int,
//        @SerialName("results")
//        val results: List<MovieResult>,
//        @SerialName("total_results")
//        val totalResults: Int,
//        @SerialName("total_pages")
//        val totalPages: Int
//) : Parcelable
//
//
