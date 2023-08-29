package com.example.lovecalculator.ui.history

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.ui.history.adapter.HistoryAdapter

class HistoryFragment : Fragment() {

    private lateinit var binding:FragmentHistoryBinding
    private val adapter = HistoryAdapter(this::onLongClickItem,this::onClickItem)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHistory.adapter = adapter
        loadAllData()


    }

    private fun loadAllData() {
        val data =App.appDatabase.loveDao().getAll()
        adapter.addTasks(data)
    }

    private fun onLongClickItem(loveModel: LoveModel){
        showDeleteDialog(loveModel)
    }

    private fun onClickItem(loveModel: LoveModel){
        showTimeDialog(loveModel)
    }

    private fun showTimeDialog(loveModel: LoveModel) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Время создания записи")
            .setMessage("14:30")
            .setCancelable(true)
            .setPositiveButton("OK"){_,_ ->}
            .show()
    }

    private fun showDeleteDialog(loveModel: LoveModel){
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(loveModel.firstName + " and " + loveModel.secondName)
            .setMessage("Вы уверены что хотите удалить эту запись?")
            .setCancelable(true)
            .setPositiveButton("Да") { _, _ ->
                App.appDatabase.loveDao().delete(loveModel)
                loadAllData()
            }
            .setNegativeButton("Нет"){_,_ ->}
            .show()

    }



}