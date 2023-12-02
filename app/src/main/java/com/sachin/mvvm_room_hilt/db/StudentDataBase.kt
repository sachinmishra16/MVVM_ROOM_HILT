package com.sachin.mvvm_room_hilt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [StudentDetail::class], version = 1)
abstract class StudentDataBase :RoomDatabase()
{
    abstract fun getDao():StudentDao
}