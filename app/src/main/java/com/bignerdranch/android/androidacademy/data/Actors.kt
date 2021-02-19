package com.bignerdranch.android.androidacademy.data

import kotlinx.serialization.*

@Serializable
data class Credit(
    val id: Long,
    val cast: List<Cast>
)

@Serializable
data class Cast(
    val id: Long,
    val name: String,

    @SerialName("original_name")
    val originalName: String,

    @SerialName("profile_path")
    val profilePath: String? = null

)
