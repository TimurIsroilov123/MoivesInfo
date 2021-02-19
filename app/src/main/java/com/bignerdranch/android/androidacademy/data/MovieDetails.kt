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
    val genres: List<Genre>,
    @SerialName("poster_path")
    val posterPath: String? = null,
    val runtime: Long,

): Parcelable

@Serializable
@Parcelize
data class Genre (
    val id: Long,
    val name: String
): Parcelable


