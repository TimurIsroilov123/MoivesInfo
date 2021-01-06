package com.bignerdranch.android.androidacademy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Actor(
    val id: Int,
    val name: String,
    val picture: String
): Parcelable