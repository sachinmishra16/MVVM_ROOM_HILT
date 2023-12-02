package com.sachin.mvvm_room_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sachin.mvvm_room_hilt.db.StudentDao
import com.sachin.mvvm_room_hilt.db.StudentDetail
import javax.inject.Inject

class StudentRepository @Inject constructor(var studentDao: StudentDao)
{
    var mutableLiveData=MutableLiveData<List<StudentDetail>>()

    var liveDataRepository:LiveData<List<StudentDetail>>?=null
        get() = mutableLiveData

    suspend fun insertData(studentDetail: StudentDetail)
    {
        studentDao.saveData(studentDetail)
    }

    suspend fun upDateData(studentDetail: StudentDetail)
    {
        studentDao.updateData(studentDetail)
    }

    suspend fun deleteData(studentDetail: StudentDetail)
    {
        studentDao.deleteData(studentDetail)
    }

    suspend fun getData()
    {
       var result= studentDao.getData()
        if (result!=null)
        {
            mutableLiveData.value=result
        }
    }
}