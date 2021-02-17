package com.bignerdranch.android.androidacademy.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class, ActorEntity::class], version = 4
)
abstract class MovieDataBase : RoomDatabase() {

    abstract val movieDao: MoviesDAO
    abstract val actorsDAO: ActorsDAO

    companion object {
        fun create(appContext: Context): MovieDataBase = Room.databaseBuilder(
            appContext,
            MovieDataBase::class.java,
            "movies.db"
        ).fallbackToDestructiveMigration().build()
    }
}