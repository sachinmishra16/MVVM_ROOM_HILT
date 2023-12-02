package com.sachin.mvvm_room_hilt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachin.mvvm_room_hilt.databinding.DataLayoutBinding
import com.sachin.mvvm_room_hilt.db.StudentDetail

class DataBaseAdapter(var context:Context,var datalist:List<StudentDetail>):RecyclerView.Adapter<DataBaseAdapter.DataHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.data_layout,parent,false)
        return DataHolder(view)
    }

    override fun getItemCount(): Int {

       return datalist.size
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.binding.tvID.text=datalist.get(position).id.toString()
        holder.binding.tvName.text=datalist.get(position).name
        holder.binding.tvMobile.text=datalist.get(position).mobile
    }
    class DataHolder(itemview:View) :RecyclerView.ViewHolder(itemview)
    {
        var binding=DataLayoutBinding.bind(itemview)
    }

}