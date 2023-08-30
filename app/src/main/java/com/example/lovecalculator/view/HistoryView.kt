package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface HistoryView {

    fun initRecyclerView(historyList: List<LoveModel>)

    fun showTimeDialog(time:Long)

    fun showDeleteDialog(loveModel: LoveModel)
}