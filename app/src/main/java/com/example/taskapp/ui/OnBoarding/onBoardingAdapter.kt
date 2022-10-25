package com.example.taskapp.ui.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.data.onBoard
import com.example.taskapp.databinding.ItemOnboardBinding

class onBoardingAdapter(private val onClick : () -> Unit) : RecyclerView.Adapter<onBoardingAdapter.onBoardingViewHolder>() {
    private val array = arrayListOf<onBoard>(
        onBoard(title = "Title = 1" , "desc=1" , R.drawable.img),
        onBoard(title = "Title = 2" , "desc=2" , R.drawable.img_2),
        onBoard(title = "Title = 3" , "desc=3" , R.drawable.img_3png)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemOnboardBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount() = array.size

    inner class onBoardingViewHolder(private val binding:ItemOnboardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(onBoard: onBoard) {
            binding.textTitle.text = onBoard.title
            binding.textDesc.text = onBoard.desc
            binding.btnStart.isVisible = adapterPosition == array.lastIndex
            binding.textSkip.isVisible = adapterPosition != array.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.textSkip.setOnClickListener{
                onClick()
            }

        }
    }
}