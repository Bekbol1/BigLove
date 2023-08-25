package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.ui.CalculateFragment.Companion.MODEL_KEY

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

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
        with(binding){
            val result = arguments?.getSerializable(MODEL_KEY) as LoveModel
            tvFirstname.text = result.firstName
            tvSecondname.text = result.secondName
            tvPercent.text = result.percentage
        }

    }

    private fun initListeners() {
        with(binding){
            btnTryAgain.setOnClickListener {

                findNavController().navigateUp()
            }
        }
    }


}