package com.example.lovecalculator.view

import android.health.connect.datatypes.units.Percentage

interface ResultView {

    fun showLove(firstName:String,secondName:String,percentage: String,wishes:String)

}