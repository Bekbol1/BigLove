package com.example.lovecalculator.model

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun isOnBoardingShowed():Boolean{
        return sharedPreferences.getBoolean("key",false)
    }

    fun onBoardingShowed(){
        sharedPreferences.edit().putBoolean("key",true).apply()
    }

}