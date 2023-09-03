package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface LoveView {

    fun navigateToResultFragment(loveModel: LoveModel)
    fun showToast(msg:String)

    fun navigateToOnBoardFragment()

}