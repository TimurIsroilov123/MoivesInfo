package com.bignerdranch.android.androidacademy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.MoviesDataSource

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