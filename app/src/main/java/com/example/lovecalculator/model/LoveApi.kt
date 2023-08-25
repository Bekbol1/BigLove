package com.example.lovecalculator.model

import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateCompatibility(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "01caf2b4d1mshd5cff5633b5324bp1e3d63jsn3b3bb154b9a8",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ):Call<LoveModel>

}