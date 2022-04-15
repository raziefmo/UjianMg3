package com.adl.ujianmg3.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class DataModel (@PrimaryKey(autoGenerate = true) val id:Long = 0,
                 val nama:String, val umur:String,
                 val photo:String) : Parcelable


