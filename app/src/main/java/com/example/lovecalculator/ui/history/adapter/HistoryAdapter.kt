package com.example.lovecalculator.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.model.LoveModel

class HistoryAdapter(
    val onLongClickItem: (loveModel: LoveModel) -> Unit,
    val onClickItem: (loveModel: LoveModel) -> Unit
) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val list = arrayListOf<LoveModel>()

    fun addLove(loves: List<LoveModel>) {
        list.clear()
        list.addAll(loves)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(loveModel: LoveModel) {
            with(binding) {
                tvFirstname.text = loveModel.firstName
                tvPercent.text = (loveModel.percentage + "%")
                tvSecondname.text = loveModel.secondName


                itemView.setOnClickListener {
                    onClickItem(loveModel)
                }
                itemView.setOnLongClickListener {
                    onLongClickItem(loveModel)
                    true
                }
            }
        }

    }


}