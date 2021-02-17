package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MoviesRep.toMovie
import com.bignerdranch.android.androidacademy.movieList.MovieListViewModel
import com.bignerdranch.android.androidacademy.movieList.MovieListViewModelFactory
import com.bignerdranch.android.androidacademy.util.ResProvider

class FragmentMoviesList :
    Fragment(R.layout.fragment_movies_list),
    OnItemClickListener {

    private var listener: OnMovieItemClickListener? = null
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter(this) }

    private val viewModel by viewModels<MovieListViewModel> {
        MovieListViewModelFactory(ResProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        viewModel.loadNewMovies()


        if (context is OnMovieItemClickListener)
            listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireContext()
        val rvMovie = view.findViewById<RecyclerView>(R.id.rv_movie)

        viewModel.observableMovies.observe(this.viewLifecycleOwner) {
            movieAdapter.update(it.map {movie -> movie.toMovie() })
        }

        rvMovie.adapter = movieAdapter
    }

    override fun onItemClick(movie: Movie) {
        listener?.onItemClickShowDetail(movie)
    }
}

