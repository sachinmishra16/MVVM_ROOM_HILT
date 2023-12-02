package com.sachin.mvvm_room_hilt.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {

    @Insert
    suspend fun saveData(studentDetail: StudentDetail)

    @Update
    suspend fun updateData(studentDetail: StudentDetail)

    @Delete
    suspend fun deleteData(studentDetail: StudentDetail)

    @Query("SELECT * FROM student")
    suspend fun getData():List<StudentDetail>
}