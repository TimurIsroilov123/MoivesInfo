package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.movieDetails.MovieDetailsViewModel
import com.bignerdranch.android.androidacademy.movieDetails.MovieDetailsViewModelFactory
import com.bignerdranch.android.androidacademy.util.ResProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movies_details.*


class FragmentMoviesDetails() :
    Fragment(R.layout.fragment_movies_details) {
    private var listener: OnMovieItemClickListener? = null
    private val actorAdapter: ActorAdapter by lazy { ActorAdapter() }

    private val viewModel by viewModels<MovieDetailsViewModel> {
        MovieDetailsViewModelFactory(ResProvider(requireContext()))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieItemClickListener)
            listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setValues(this.arguments?.getParcelable("currentMovie"))

        view.findViewById<TextView>(R.id.back_btn)
            .setOnClickListener {
                listener?.onItemClickShowList()
            }
    }

    private fun setValues(movie: Movie?) {
        movie?.apply {
            genre_txt.text = detail?.genres?.joinToString { it.name }
            description_view.text = overview
            film_title.text = title
            Glide.with(iv_backdrop.context)
                .load(BASE_IMG_URL + backdropPath)
                .centerCrop()
                .into(iv_backdrop)
            tv_age.text = if (adult) "18+" else "12+"
        }
        viewModel.loadActors(movie!!.id, requireContext())
        viewModel.actorsLiveData.observe(this.viewLifecycleOwner, Observer {
            actorAdapter.updateActors(it)
        })

        rv_actor.adapter = actorAdapter
    }

}