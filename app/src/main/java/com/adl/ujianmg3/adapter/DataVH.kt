package com.adl.ujianmg3.adapter

import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_add_data.view.*
import kotlinx.android.synthetic.main.item_data.view.*
import kotlinx.android.synthetic.main.item_data.view.txtUmuri

class DataVH (view: View) : RecyclerView.ViewHolder(view) {
   // val edit = view.btnEdit
    val nama = view.txtNamai
    val umur = view.txtUmuri
    val status =view.context
    val image = view.imageView
    val context = view.context

    fun bindData(adapter:DataAdapter,position: Int) {

        nama.setText(adapter.data.get(position).nama)
        umur.setText(adapter.data.get(position).umur)
       // status.setText(adapter.data.get(position).status)
        //Glide.with(status).load(adapter.data.get(position).status)
        Glide.with(context).load(adapter.data.get(position).photo).into(image)

           // edit.setOnClickListener {
          //  adapter.




       // }

    }


}