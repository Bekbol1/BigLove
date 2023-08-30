package com.example.lovecalculator

import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.view.LoveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class Presenter(val loveView: LoveView) {

    private var api = RetrofitService.api

    fun getLoveResult(firstName: String, secondName: String) {
        api.calculateCompatibility(
            firstName, secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {model ->
                    model.insertTime = Date().time
                    Log.e("ololo", "onResponse: ${model.insertTime}")
                    loveView.navigateToResultFragment(model)
                    App.appDatabase.loveDao().insert(model)
                    //findNavController().navigate(R.id.resultFragment, bundleOf("result" to response.body()))
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showToast(t.message.toString())
            }

        })
    }

}