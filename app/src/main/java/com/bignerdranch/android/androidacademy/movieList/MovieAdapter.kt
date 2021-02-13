package com.bignerdranch.android.androidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Movie


class MovieAdapter(
    private val listener: OnItemClickListener,
) : RecyclerView.Adapter<MovieViewHolder>() {

    private val contentData = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MovieViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(contentData[position])
    }

    fun update(movies: List<Movie>) {
        val numberOfRemovedItems = contentData.size
        contentData.clear()
        val positionStart = contentData.size
        contentData.addAll(movies)
        notifyItemRangeRemoved(0, numberOfRemovedItems)
        notifyItemRangeInserted(positionStart, positionStart + movies.size)
    }

    override fun getItemCount(): Int = contentData.size
}


