package com.adl.ujianmg3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import com.adl.ujianmg3.database.DataBase
import com.adl.ujianmg3.database.model.DataModel
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.android.synthetic.main.activity_add_data.view.*
import kotlinx.android.synthetic.main.item_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        lateinit var gender :Spinner

        btnSend.setOnClickListener({
            val data = DataModel(
                0,
                txtNama.text.toString(),
                txtUmur.text.toString(),
                txtlocation.text.toString()
               //,txtStatus.text.toString()
            )

           // val toast = Toast.makeText(this,"Kamu memilih${gender.selectedItem}",Toast.LENGTH_SHORT).show()


            GlobalScope.launch {
                DataBase.getInstance(this@AddData).dataDao().insertData(data)

                val intent = Intent()
                intent.putExtra("data",data)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

        })
    }
}