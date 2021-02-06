package com.bignerdranch.android.androidacademy

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.androidacademy.data.Movie

class MainActivity : AppCompatActivity(), OnMovieItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onItemClickShowDetail(movie: Movie) {
        val fragmentMoviesList = FragmentMoviesDetails()
        val bundle = Bundle()
        bundle.putParcelable("currentMovie", movie)
        fragmentMoviesList.arguments = bundle
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentMoviesList)
                .addToBackStack("FragmentMoviesDetails")
                .commit()
    }

    override fun onItemClickShowList() {
        supportFragmentManager.popBackStack()
    }
}