package com.adl.ujianmg3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.ujianmg3.R
import com.adl.ujianmg3.database.model.DataModel

class DataAdapter (val data:ArrayList<DataModel>) : RecyclerView.Adapter<DataVH>(){
    lateinit var parent: ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataVH {
        this.parent=parent
        return DataVH(LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false))
    }

    override fun onBindViewHolder(holder: DataVH, position: Int) {
       holder.bindData(this@DataAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size

    }


}
