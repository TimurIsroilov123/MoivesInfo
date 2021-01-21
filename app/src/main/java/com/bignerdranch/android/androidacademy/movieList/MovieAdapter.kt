package com.bignerdranch.android.androidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Combined
import com.bignerdranch.android.androidacademy.data.Movie


class MovieAdapter(
        private val listener: OnItemClickListener,
        private val contentData: Combined
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MovieViewHolder {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent,false)
        return MovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        val movie = contentData[position]
        holder.onBind(contentData.movie[position], contentData.details[position])
    }

    override fun getItemCount(): Int = contentData.movie.size
}

