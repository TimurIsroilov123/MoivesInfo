package com.bignerdranch.android.androidacademy.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.bignerdranch.android.androidacademy.data.MovieDetails

@Entity(
    tableName = "movies",
    indices = [Index("_id")]
)
class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val _id: Long = 0,

    @ColumnInfo(name = "posterPath")
    val posterPath: String,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo(name = "overvie")
    val overview: String,

    @ColumnInfo(name = "genreIDS")
    val genreIDS: List<Long>,

    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "posterPath")
    val title: String,

    @ColumnInfo(name = "backdropPath")
    val backdropPath: String?,

    @ColumnInfo(name = "posterPath")
    val popularity: Double,

    @ColumnInfo(name = "voteCount")
    val voteCount: Long,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "detail")
    var detail: MovieDetails? = null
)
