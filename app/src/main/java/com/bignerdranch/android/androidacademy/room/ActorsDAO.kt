package com.bignerdranch.android.androidacademy.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.androidacademy.data.Cast

@Dao
interface ActorsDAO {

    @Query("Select * From actors")
    suspend fun getAll(): List<ActorEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(actorEntity: ActorEntity)

    @Query("Delete From actors")
    suspend fun deleteAll()
}