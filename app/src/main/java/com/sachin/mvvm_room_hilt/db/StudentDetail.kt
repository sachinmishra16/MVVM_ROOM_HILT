package com.sachin.mvvm_room_hilt.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sachin.mvvm_room_hilt.DataBaseModule

@Entity(tableName = "student")
data class StudentDetail(
    @PrimaryKey(autoGenerate = false)
    var id:Int,
    var name:String,
    var mobile:String
)