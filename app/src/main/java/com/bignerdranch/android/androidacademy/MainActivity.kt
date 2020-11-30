package com.bignerdranch.android.androidacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnMovieItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onItemClickShowDetail() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentMoviesDetails())
            .addToBackStack("FragmentMoviesDetails")
            .commit()
    }

    override fun onItemClickShowList() {
        supportFragmentManager.popBackStack()
    }
}