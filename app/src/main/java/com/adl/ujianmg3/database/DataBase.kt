package com.adl.ujianmg3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adl.ujianmg3.database.dao.DataDao
import com.adl.ujianmg3.database.model.DataModel


@Database( version = 1,entities = [DataModel::class])
abstract class DataBase : RoomDatabase() {
    abstract  fun dataDao(): DataDao
    companion object{

        var instance:DataBase?=null

        @Synchronized
        fun getInstance(ctx: Context):DataBase{

            if(instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                  DataBase ::class.java,
                    "db_data"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }


    }
}






//
//    private val movieCallback = object:Callback(){
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            popu
//        }
//    }

