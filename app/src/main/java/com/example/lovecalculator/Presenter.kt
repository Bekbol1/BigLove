package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.Pref
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.view.LoveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import javax.inject.Inject

class Presenter @Inject constructor(private val api: LoveApi) {

    lateinit var loveView:LoveView

    @Inject
    lateinit var loveDao: LoveDao

    @Inject
    lateinit var pref: Pref

    fun getLoveResult(firstName: String, secondName: String) {
        api.calculateCompatibility(
            firstName, secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {model ->
                    model.insertTime = Date().time
                    Log.e("ololo", "onResponse: ${model.insertTime}")
                    loveView.navigateToResultFragment(model)
                    loveDao.insert(model)
                    //App.appDatabase.loveDao().insert(model)
                    //findNavController().navigate(R.id.resultFragment, bundleOf("result" to response.body()))
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showToast(t.message.toString())
            }

        })
    }

    fun attachView(view: LoveView){
        this.loveView = view

    }

    fun showOnBoard(){
        if (!pref.isOnBoardingShowed()){
            loveView.navigateToOnBoardFragment()
        }
    }


}