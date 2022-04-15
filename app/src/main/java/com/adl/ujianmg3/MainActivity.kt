package com.adl.ujianmg3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.ujianmg3.adapter.DataAdapter
import com.adl.ujianmg3.database.DataBase
import com.adl.ujianmg3.database.model.DataModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

//            if(result.data?.hasExtra("data")!!){
//                lstMovie.add(result.data!!.extras?.getParcelable<MovieModel>("data")!!)
//            }
                GlobalScope.launch {

                    lstData.clear()
                    lstData.addAll(ArrayList(getAllData()))

                    this@MainActivity.runOnUiThread({
                        DataAdapter.notifyDataSetChanged()

                    })


                }
            }
        }

         lateinit var DataAdapter: DataAdapter
         var lstData = ArrayList<DataModel>()
         override fun onCreate(savedInstanceState: Bundle?) {
                   super.onCreate(savedInstanceState)
                   setContentView(R.layout.activity_main)

        GlobalScope.launch {

            lstData = ArrayList(getAllData())


            this@MainActivity.runOnUiThread({
               DataAdapter = DataAdapter(lstData)
                lstItemData.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = DataAdapter
                }
            })

        }
        btnAddUser.setOnClickListener({
            val intent = Intent(this@MainActivity,AddData::class.java)
            resultLauncher.launch(intent)
        })

    }

    fun getAllData():List<DataModel>{

        return DataBase.getInstance(this@MainActivity).dataDao().getAll()

    }

}
