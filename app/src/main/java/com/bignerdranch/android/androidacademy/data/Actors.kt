package com.bignerdranch.android.androidacademy.data

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*

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
    val originalName: String = "unknown",

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
