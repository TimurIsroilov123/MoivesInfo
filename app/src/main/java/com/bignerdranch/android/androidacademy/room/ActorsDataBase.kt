package com.bignerdranch.android.androidacademy.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ActorEntity::class], version = 1)
abstract class ActorsDataBase : RoomDatabase() {
    abstract val actorsDAO: ActorsDAO

    companion object {
        fun create(appContext: Context): ActorsDataBase = Room.databaseBuilder(
            appContext,
            ActorsDataBase::class.java,
            "actors.db"
        ).fallbackToDestructiveMigration().build()
    }
}