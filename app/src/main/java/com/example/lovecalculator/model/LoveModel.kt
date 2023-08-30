package com.example.lovecalculator.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Calendar
import java.util.Date

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var insertTime:Long
) : Serializable
