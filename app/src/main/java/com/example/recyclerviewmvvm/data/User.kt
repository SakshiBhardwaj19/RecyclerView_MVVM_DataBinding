package com.example.recyclerviewmvvm.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val name: String, val age: Int, val location: String, val aboutMe: String) :Parcelable
