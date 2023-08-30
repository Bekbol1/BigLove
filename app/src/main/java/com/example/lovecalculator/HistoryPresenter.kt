package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.HistoryView

class HistoryPresenter(private val historyView:HistoryView) {

    fun getHistoryList(){
        historyView.initRecyclerView(App.appDatabase.loveDao().getAll())
    }

    fun deleteHistory(loveModel: LoveModel){
        App.appDatabase.loveDao().delete(loveModel)
        getHistoryList()
    }

    fun getTime(loveModel: LoveModel){
        Log.d("ololo", "getDate: ${loveModel.insertTime}")
        loveModel.insertTime?.let { historyView.showTimeDialog(it) }
    }

}