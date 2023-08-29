package com.example.lovecalculator.ui.calculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.Presenter
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import com.example.lovecalculator.view.LoveView

class CalculateFragment : Fragment(),LoveView {

    private lateinit var binding: FragmentCalculateBinding
    private val presenter = Presenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                presenter.getLoveResult(etFirstname.text.toString(),etSecondname.text.toString())
            }
            containerHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    override fun navigateToResultFragment(loveModel: LoveModel) {
        App.appDatabase.loveDao().insert(loveModel)
        findNavController().navigate(R.id.resultFragment, bundleOf(MODEL_KEY to loveModel))
        binding.etFirstname.text.clear()
        binding.etSecondname.text.clear()
    }

    override fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    companion object{
        val MODEL_KEY = "model.key"
    }


}