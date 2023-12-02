package com.sachin.mvvm_room_hilt

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sachin.mvvm_room_hilt.db.StudentDao
import com.sachin.mvvm_room_hilt.db.StudentDataBase
import com.sachin.mvvm_room_hilt.db.StudentDetail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule
{
    @Provides
    @Singleton
    fun getDBInstance(@ApplicationContext context: Context):StudentDataBase
    {
         return Room.databaseBuilder(context,StudentDataBase::class.java,"studentDB").build()
    }

    @Provides
    fun getDaoInstance (studentDataBase: StudentDataBase):StudentDao
    {
        return studentDataBase.getDao()
    }
}