package com.example.lovecalculator.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.lovecalculator.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun loveDao():LoveDao

}