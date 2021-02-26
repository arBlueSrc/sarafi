package com.arash.applikatask.ui.car

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.applikatask.databinding.RecyclerItemArzBinding
import com.arash.applikatask.databinding.RecyclerItemCarBinding
import com.arash.applikatask.model.localdbmodel.DbModel

class CarAdapter : ListAdapter<DbModel, CarAdapter.TodayViewHolder>(TodayDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val binding = RecyclerItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayViewHolder(binding)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {

        holder.binding.data = currentList[position]

    }

    class TodayViewHolder(val binding: RecyclerItemCarBinding) : RecyclerView.ViewHolder(binding.root)

}


class TodayDiffUtil : DiffUtil.ItemCallback<DbModel>(){
    override fun areItemsTheSame(
        oldItem: DbModel,
        newItem: DbModel
    ): Boolean {
        return oldItem.Id  == newItem.Id
    }

    override fun areContentsTheSame(
        oldItem: DbModel,
        newItem: DbModel
    ): Boolean {
        return oldItem == newItem
    }

}