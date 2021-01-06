package com.bignerdranch.android.androidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MovieAdapter(
        private val listener: OnItemClickListener
        ): RecyclerView.Adapter<MovieViewHolder>(){


    private val contentData = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MovieViewHolder {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent,false)
        return MovieViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = contentData[position]
        holder.onBind(movie)
    }

    fun update(movieList: List<Movie>) {
        contentData.addAll(movieList)
        notifyItemRangeInserted(0, contentData.size)
    }

    override fun getItemCount(): Int = contentData.size
}

