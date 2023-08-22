package com.example.lovecalculator.ui

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.text.SpannableString
import android.text.style.LineBackgroundSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.LoveModel
import com.example.lovecalculator.R
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding

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
                RetrofitService().api.calculateCompatibility(
                    etFirstname.text.toString(),
                    etSecondname.text.toString()
                ).enqueue(object :retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("ololo","onResponse: ${response.body()}")
                            findNavController().navigate(R.id.resultFragment, bundleOf("result" to response.body()))
                        }
                        etFirstname.text.clear()
                        etSecondname.text.clear()

                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireContext(),"OnFailure: ${t.message}",Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
    }


}