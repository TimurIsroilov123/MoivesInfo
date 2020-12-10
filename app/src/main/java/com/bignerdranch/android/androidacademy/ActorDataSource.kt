package com.bignerdranch.android.androidacademy

class ActorDataSource {
    fun getActors(): List<Actor>{
        return listOf(
                Actor(R.drawable.robert, "Robert Downey Jr."),
                Actor(R.drawable.chris, "Chris Evans"),
                Actor(R.drawable.mark, "Mark Ruffalo"),
                Actor(R.drawable.tor, "Chris Hemsworth")
        )
    }

}