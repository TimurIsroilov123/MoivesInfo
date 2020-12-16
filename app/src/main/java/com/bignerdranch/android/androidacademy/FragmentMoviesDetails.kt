package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {
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

        val rvActor = view.findViewById<RecyclerView>(R.id.rv_actor)
        val adapter = ActorAdapter(ActorDataSource().getActors())
        rvActor.adapter = adapter

        view.findViewById<TextView>(R.id.back_btn)
            .setOnClickListener {
                listener?.onItemClickShowList()
            }
    }
}