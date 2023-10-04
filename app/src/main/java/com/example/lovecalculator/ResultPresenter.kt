package com.example.lovecalculator

import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.ResultView

class ResultPresenter(private val resultView: ResultView) {

    fun getData(loveModel: LoveModel) {
        resultView.showLove(
            loveModel.firstName,
            loveModel.secondName,
            loveModel.percentage
        )
    }

}