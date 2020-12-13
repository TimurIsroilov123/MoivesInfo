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
//Actor(R.drawable.robert, R.string.robert),
//Actor(R.drawable.chris, R.string.chris_e),
//Actor(R.drawable.mark, R.string.mark),
//Actor(R.drawable.tor, R.string.chris_h)