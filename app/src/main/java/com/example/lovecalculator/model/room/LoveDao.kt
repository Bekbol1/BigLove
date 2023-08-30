package com.example.lovecalculator.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAll():List<LoveModel>

    @Insert
    fun insert(loveModel: LoveModel)

    @Delete
    fun delete(loveModel: LoveModel)

}