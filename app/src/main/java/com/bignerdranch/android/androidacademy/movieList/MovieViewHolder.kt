package com.bignerdranch.android.androidacademy

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Movie
import com.bumptech.glide.Glide


class MovieViewHolder(
        view: View,
        private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(view) {

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
    fun onBind(movie: Movie) {
        this.movie = movie
        title.text = movie.originalTitle
        img.maxHeight = 240
//        age.text = movie.minimumAge.toString() + "+"
//        like.setImageResource(R.drawable.like)
//        ratingBar.rating = movie.ratings / 2
//        duration.text = movie.runtime.toString()
//        views.text = movie.numberOfRatings.toString()
    }
}