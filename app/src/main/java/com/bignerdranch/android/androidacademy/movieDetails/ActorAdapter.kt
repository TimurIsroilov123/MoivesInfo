package com.bignerdranch.android.androidacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.androidacademy.data.Cast

class ActorAdapter() :
    RecyclerView.Adapter<ActorViewHolder>() {

    private val contentData = mutableListOf<Cast>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ActorViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = contentData[position]
        holder.onBind(actor)
    }

    fun updateActors(actors: List<Cast>) {
        contentData.addAll(actors)
        notifyItemRangeInserted(0, actors.size)
    }

    override fun getItemCount(): Int = contentData.size
}