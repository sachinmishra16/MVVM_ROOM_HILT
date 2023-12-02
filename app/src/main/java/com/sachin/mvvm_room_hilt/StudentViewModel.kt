package com.sachin.mvvm_room_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.mvvm_room_hilt.db.StudentDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(var studentRepository: StudentRepository):ViewModel() {
    /*init {
        viewModelScope.launch {
            studentRepository.getData()

        }

    }*/
    var liveDataVideModel:LiveData<List<StudentDetail>>?=null
        get() = studentRepository.liveDataRepository

    suspend fun insertData(studentDetail: StudentDetail)
    {
        studentRepository.insertData(studentDetail)
    }

    suspend fun getData()
    {
       // liveDataVideModel=studentRepository.mutableLiveData
        studentRepository.getData()
    }

    suspend fun deleteData(studentDetail: StudentDetail)
    {
        studentRepository.deleteData(studentDetail)
    }

    suspend fun updateData(studentDetail: StudentDetail)
    {
        studentRepository.upDateData(studentDetail)
    }
}