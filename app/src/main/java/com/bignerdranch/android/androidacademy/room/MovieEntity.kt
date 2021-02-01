package com.bignerdranch.android.androidacademy.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.bignerdranch.android.androidacademy.data.MovieDetails

@Entity(
    tableName = "movies",
    indices = [Index("id")]
)
class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "posterPath")
    val posterPath: String,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "backdropPath")
    val backdropPath: String?,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "voteCount")
    val voteCount: Long,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "runtime")
    val runtime: Long,

    @ColumnInfo(name = "genres")
    val genres: String
)
