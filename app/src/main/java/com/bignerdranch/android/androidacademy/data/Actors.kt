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
    val adult: Boolean? = null,
    val gender: Long? = null,
    val id: Long,
    val name: String,

    @SerialName("original_name")
    val originalName: String? = null,

    val popularity: Double? = null,

    @SerialName("profile_path")
    val profilePath: String? = null,

    @SerialName("cast_id")
    val castID: Long? = null,

    val character: String? = null,

    @SerialName("credit_id")
    val creditID: String? = null,

    val order: Long? = null,
    val job: String? = null
)
