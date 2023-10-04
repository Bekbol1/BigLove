package com.example.lovecalculator.ui.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardBinding
import com.example.lovecalculator.model.OnBoardModel

class OnBoardAdapter(private val onClick:()->Unit):Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val list = arrayListOf(
        OnBoardModel(
            R.raw.couplewalk,
            "Интересная логика",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        OnBoardModel(
            R.raw.cupidlove,
            "Удобное пользование",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        OnBoardModel(
            R.raw.lovemessage,
            "Отличный дизайн",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        ),
        OnBoardModel(
            R.raw.animation_lmezrvak,
            "Spide и Kitty ждут вас",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding): ViewHolder(binding.root){
        fun bind(onBoard: OnBoardModel) = with(binding){
            tvTitle.text = onBoard.title
            tvDesc.text = onBoard.description
            onBoard.anim?.let {
                ivBoard.setAnimation(it)
                ivBoard.playAnimation()
            }
            btnStart.isVisible = adapterPosition == list.lastIndex
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }
        }
    }

}