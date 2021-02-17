package com.bignerdranch.android.androidacademy.data

import kotlinx.serialization.*



@Serializable
data class Credit(
    val id: Long,
    val cast: List<Cast>
)

@Serializable
data class Cast(
    val adult: Boolean = false,
    val gender: Long = 1,
    val id: Long,
    val name: String,

    @SerialName("original_name")
    val originalName: String,

    val popularity: Double = 0.0,

    @SerialName("profile_path")
    val profilePath: String? = null,

    @SerialName("cast_id")
    val castID: Long = 0,

    val character: String = "unknown",

    @SerialName("credit_id")
    val creditID: String = "unknown",

    val order: Long = 0,
    val job: String = "unknown"
)
