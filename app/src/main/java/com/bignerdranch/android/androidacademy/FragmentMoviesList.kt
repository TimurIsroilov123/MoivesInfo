package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class FragmentMoviesList :
        Fragment(R.layout.fragment_movies_list),
        OnItemClickListener {

    private var listener: OnMovieItemClickListener? = null
    private val myAdapter: MovieAdapter by lazy { MovieAdapter(this) }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieItemClickListener) {
            listener = context
        }

        viewLifecycleOwner
                .lifecycleScope
                .launch(IO) {
                    val movieList = loadMovies(context)
                    myAdapter.update(movieList)
                }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMovie = view.findViewById<RecyclerView>(R.id.rv_movie)

        rvMovie.adapter = myAdapter
    }

    override fun onItemClick(movie: Movie) {
        listener?.onItemClickShowDetail(movie)
    }
}






