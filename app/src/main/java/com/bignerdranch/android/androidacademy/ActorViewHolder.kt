package com.bignerdranch.android.androidacademy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val avatar = itemView.findViewById<ImageView>(R.id.iv_avatar)
    private val name = itemView.findViewById<TextView>(R.id.tv_name)

    fun onBind(actor: Actor){
        avatar.setImageResource(actor.img)
        name.text = actor.name
    }

}