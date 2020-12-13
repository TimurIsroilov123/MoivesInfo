package com.bignerdranch.android.androidacademy

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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

    init{
        itemView.setOnClickListener {
             listener.onItemClick(movie!!)
        }
    }

    fun onBind(movie: Movie){
        this.movie = movie
        img!!.setImageResource(movie.img)
        title!!.text = movie.title
        age!!.text = movie.age
        if (movie.isLiked)
            like!!.setImageResource(R.drawable.liked)
        else
            like!!.setImageResource(R.drawable.like)
        genres!!.text = movie.genres
        ratingBar!!.rating = movie.rate.toFloat()
        views!!.text = movie.reviews.toString()
        duration!!.text = movie.duration.toString()
    }
}