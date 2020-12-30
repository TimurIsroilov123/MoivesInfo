package com.bignerdranch.android.androidacademy

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import java.security.AccessController.getContext


class  MovieViewHolder(
        view: View,
        private val listener: OnItemClickListener
        ): RecyclerView.ViewHolder(view) {

    private val img: ImageView = view.findViewById(R.id.iv_movie)
    private val title: TextView = view.findViewById(R.id.movie_title)
    private val age: TextView = view.findViewById(R.id.tv_age)
    private val like: ImageView = view.findViewById(R.id.iv_like)
    private val genres: TextView = view.findViewById(R.id.tv_genre)
    private val ratingBar: RatingBar = view.findViewById(R.id.ratingbar)
    private val views: TextView = view.findViewById(R.id.tv_views)
    private val duration: TextView = view.findViewById(R.id.tv_duration)

    private var movie: Movie? = null

    init {
        itemView.setOnClickListener {
             listener.onItemClick(movie!!)
        }
    }

    @SuppressLint("SetTextI18n")
    fun onBind(movie: Movie){
        this.movie = movie
        title.text = movie.title
        img.maxHeight = 240
        Glide.with(img.context)
                .load(movie.poster)
                .centerCrop()
                .into(img)
        age.text = movie.minimumAge.toString() + "+"
        genres.text = movie.genres.joinToString{ it.name }
        like.setImageResource(R.drawable.like)
        ratingBar.rating = movie.ratings/2
        duration.text = movie.runtime.toString()
        views.text = movie.numberOfRatings.toString()
    }
}