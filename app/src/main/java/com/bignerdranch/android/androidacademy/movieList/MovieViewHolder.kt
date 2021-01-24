package com.bignerdranch.android.androidacademy

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.BASE_URL
import com.bignerdranch.android.androidacademy.data.Movie
import com.bignerdranch.android.androidacademy.data.MovieDetails
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext


class MovieViewHolder(
        view: View,
        private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(view) {

    private val img: ImageView = view.findViewById(R.id.iv_movie)
    private val tvTitle: TextView = view.findViewById(R.id.movie_title)
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
        movie.apply {
            tvTitle.text = title
            Glide
                .with(itemView.context)
                .load(BASE_IMG_URL + posterPath)
                .centerCrop()
                .placeholder(R.drawable.movie)
                .into(img)
            age.text = if (adult) "18+" else "12+"
            ratingBar.rating = (voteAverage/2.0).toFloat()
            views.text = voteCount.toString()
            genres.text = movie.detail?.genres?.joinToString { it.name }
            duration.text = detail?.runtime.toString()
        }
    }
}

const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w780/"