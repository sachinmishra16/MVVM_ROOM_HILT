package com.sachin.mvvm_room_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sachin.mvvm_room_hilt.databinding.ActivityMainBinding
import com.sachin.mvvm_room_hilt.db.StudentDetail
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var studentViewModel: StudentViewModel
    lateinit var dataBaseAdapter: DataBaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAllData.layoutManager=LinearLayoutManager(this)
        studentViewModel=ViewModelProvider(this).get(StudentViewModel::class.java)

        binding.btnSaveData.setOnClickListener {

            MainScope().launch {
                studentViewModel.insertData(StudentDetail(binding.etID.text.toString().toInt(),binding.etName.text.toString()
                    ,binding.etMobile.text.toString()))
            }
        }

        binding.btnUpdateData.setOnClickListener {
            MainScope().launch {

                studentViewModel.updateData(StudentDetail(binding.etID.text.toString().toInt(),binding.etName.text.toString()
                    ,binding.etMobile.text.toString()))
            }
        }
        binding.btnDeleteData.setOnClickListener {

            MainScope().launch {
                studentViewModel.deleteData(StudentDetail(binding.etID.text.toString().toInt(),binding.etName.text.toString()
                    ,binding.etMobile.text.toString()))
            }

        }

        binding.btnGetData.setOnClickListener {
            MainScope().launch {
                studentViewModel.getData()
                studentViewModel.liveDataVideModel?.observe(this@MainActivity, Observer {
                    Log.d("dataInDataBase",it.toString())
                    dataBaseAdapter=DataBaseAdapter(this@MainActivity,it)
                    binding.rvAllData.adapter=dataBaseAdapter
                })
            }
        }

    }
}