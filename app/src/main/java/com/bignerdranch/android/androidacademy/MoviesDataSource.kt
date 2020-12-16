package com.bignerdranch.android.androidacademy

import com.bignerdranch.android.androidacademy.Movie

class MoviesDataSource {
    fun getMovies() : List<Movie> {
        return listOf(
                Movie(R.drawable.avengers_img,"Avengers: End Game", "13+", false,"Action, Adventure, Drama", 4,125,137),
                Movie( R.drawable.tenet_img,"Tenet", "16+", true,"Action, Sci-Fi, Thriller", 5,98,98),
                Movie(R.drawable.black_widow_img,"Black Widow", "13+", false,"Action, Adventure, Sci-Fi", 4,38,102),
                Movie(R.drawable.ww_img,"Wonder Woman 1984", "13+", false,"Action, Adventure, Fantasy", 5,74,120)
        )
    }
}