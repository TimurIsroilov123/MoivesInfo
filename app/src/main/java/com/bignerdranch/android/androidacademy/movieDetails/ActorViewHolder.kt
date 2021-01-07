package com.bignerdranch.android.androidacademy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val avatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
    private val name = itemView.findViewById<TextView>(R.id.tv_name)

    fun onBind(actor: Actor) {
        Glide.with(avatar.context)
                .load(actor.picture)
                .into(avatar)
        name.text = actor.name
    }
}