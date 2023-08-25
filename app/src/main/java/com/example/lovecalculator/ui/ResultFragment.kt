package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.ResultPresenter
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.ui.CalculateFragment.Companion.MODEL_KEY
import com.example.lovecalculator.view.ResultView

class ResultFragment : Fragment(),ResultView {

    private lateinit var binding: FragmentResultBinding
    private val presenter = ResultPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        getResult()
    }

    private fun getResult() {
        val result = arguments?.getSerializable(MODEL_KEY) as LoveModel
        presenter.getData(result)


    }

    private fun initListeners() {
        with(binding){
            btnTryAgain.setOnClickListener {

                findNavController().navigateUp()
            }
        }
    }

    override fun showLove(
        firstName: String,
        secondName: String,
        percentage: String,
        wishes: String
    ) {
        with(binding){
            tvFirstname.text = firstName
            tvSecondname.text = secondName
            tvPercent.text = percentage
            tvWishes.text = wishes
        }
    }


}