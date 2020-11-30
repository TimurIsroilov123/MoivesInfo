package com.bignerdranch.android.androidacademy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {

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
        view.findViewById<ViewGroup>(R.id.movie_list_item)
                .setOnClickListener {
                    listener?.onItemClickShowDetail()
                }
    }
}