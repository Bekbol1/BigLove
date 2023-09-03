package com.example.lovecalculator.ui.history

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.App
import com.example.lovecalculator.HistoryPresenter
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.ui.history.adapter.HistoryAdapter
import com.example.lovecalculator.view.HistoryView
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment(), HistoryView {

    private lateinit var binding: FragmentHistoryBinding

    private val adapter = HistoryAdapter(this::onLongClickItem, this::onClickItem)

    @Inject
    lateinit var historyPresenter: HistoryPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyPresenter.attachView(this)
        historyPresenter.getHistoryList()
    }

    private fun onLongClickItem(loveModel: LoveModel) {
        historyPresenter.deleteHistory(loveModel)
    }

    private fun onClickItem(loveModel: LoveModel) {
        historyPresenter.getTime(loveModel)
    }

    override fun initRecyclerView(historyList: List<LoveModel>) {
        binding.rvHistory.adapter = adapter
        adapter.addLove(historyList)
    }

    @SuppressLint("SimpleDateFormat")
    override fun showTimeDialog(insertTime: Long) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(getString(R.string.time_of_creation))
            .setMessage(SimpleDateFormat("d MMM yyyy HH:mm:ss").format(insertTime))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .show()
    }

    override fun showDeleteDialog(loveModel: LoveModel) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle(loveModel.firstName + getString(R.string.and) + loveModel.secondName)
            .setMessage(getString(R.string.are_you_sure_to_delete_this))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                historyPresenter.deleteHistory(loveModel)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ -> }
            .show()
    }


}