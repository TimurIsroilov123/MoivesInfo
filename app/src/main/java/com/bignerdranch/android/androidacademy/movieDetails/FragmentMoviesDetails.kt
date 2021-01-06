package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movies_details.*


class FragmentMoviesDetails() :
        Fragment(R.layout.fragment_movies_details) {
    var listener: OnMovieItemClickListener? = null

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

        setValues(this.arguments?.getParcelable<Movie>("currentMovie"))

        view.findViewById<TextView>(R.id.back_btn)
                .setOnClickListener {
                    listener?.onItemClickShowList()
                }

    }

    private fun setValues(movie: Movie?) {
        tv_age.text = movie?.minimumAge.toString() + "+"
        genre_txt.text = movie?.genres?.joinToString { it.name }
        num_of_view.text = movie?.numberOfRatings.toString()
        description_view.text = movie?.overview

        val rvActor = view?.findViewById<RecyclerView>(R.id.rv_actor)
        val adapter = ActorAdapter(movie.let { it!!.actors })
        rvActor?.adapter = adapter
        film_title.text = movie?.title
        Glide.with(this)
                .load(movie?.backdrop)
                .centerCrop()
                .into(iv_backdrop)
    }
}