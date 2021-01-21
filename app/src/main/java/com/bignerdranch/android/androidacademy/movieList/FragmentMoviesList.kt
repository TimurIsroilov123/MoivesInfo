package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Combined
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MovieDetails
import com.bignerdranch.android.androidacademy.data.Page
import com.bignerdranch.android.androidacademy.movieList.MovieListViewModel
import com.bignerdranch.android.androidacademy.movieList.MovieListViewModelFactory
import com.bignerdranch.android.androidacademy.util.ResProvider

class FragmentMoviesList :
        Fragment(R.layout.fragment_movies_list),
        OnItemClickListener {

    private var listener: OnMovieItemClickListener? = null
    private lateinit var moviesList: List<Movie>
    private lateinit var combined: Combined

    lateinit var moviesDetails: List<MovieDetails>
//    private var moviesList = BaseResponse<Movie>()

    private val viewModel by viewModels<MovieListViewModel> {
        MovieListViewModelFactory(ResProvider(requireActivity()))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMovieItemClickListener) {
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

        viewModel.movieListLiveData.observe(this.viewLifecycleOwner, Observer {
            moviesList = it.results
//            val myAdapter = MovieAdapter(this, moviesList)
//            rvMovie.adapter = myAdapter
        })

        viewModel.loadDetails()

        viewModel.detailsLiveData.observe(this.viewLifecycleOwner, Observer {
            moviesDetails = it
        })

        val myAdapter = MovieAdapter(this, Combined(moviesList, moviesDetails))
        rvMovie.adapter = myAdapter
    }

    override fun onItemClick(movie: Movie) {
        listener?.onItemClickShowDetail(movie)
    }

}






