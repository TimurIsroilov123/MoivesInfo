package com.bignerdranch.android.androidacademy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Genre(val id: Int, val name: String): Parcelable