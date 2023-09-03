package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.view.HistoryView
import java.lang.annotation.Inherited
import javax.inject.Inject

class HistoryPresenter @Inject constructor(private val loveDao: LoveDao) {

    private lateinit var historyView: HistoryView

    fun getHistoryList() {
        historyView.initRecyclerView(loveDao.getAll())
    }

    fun deleteHistory(loveModel: LoveModel) {
        loveDao.delete(loveModel)
        getHistoryList()
    }

    fun getTime(loveModel: LoveModel) {
        Log.d("ololo", "getDate: ${loveModel.insertTime}")
        loveModel.insertTime?.let { historyView.showTimeDialog(it) }
    }

    fun attachView(view: HistoryView){
        this.historyView = view
    }

}