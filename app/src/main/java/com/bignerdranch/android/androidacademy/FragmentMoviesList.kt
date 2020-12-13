package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class FragmentMoviesList: Fragment(R.layout.fragment_movies_list), OnItemClickListener {

    var listener: OnMovieItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieItemClickListener){
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMovie = view.findViewById<RecyclerView>(R.id.rv_movie)

       // rvMovie.layoutManager = GridLayoutManager( context, 2)
        val myAdapter = MovieAdapter(this, MoviesDataSource().getMovies())
        rvMovie.adapter = myAdapter

        view.findViewById<ViewGroup>(R.id.rv_movie)
                .setOnClickListener {
                    listener?.onItemClickShowDetail()
                }

    }

    override fun onItemClick(movie: Movie) {
        listener?.onItemClickShowDetail()
    }

}






