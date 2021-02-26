package com.arash.applikatask.ui.arz

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.applikatask.databinding.RecyclerItemArzBinding
import com.arash.applikatask.model.localdbmodel.DbModel

class ArzAdapter : ListAdapter<DbModel, ArzAdapter.TodayViewHolder>(TodayDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val binding = RecyclerItemArzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayViewHolder(binding)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {

        holder.binding.data = currentList[position]

    }

    class TodayViewHolder(val binding: RecyclerItemArzBinding) : RecyclerView.ViewHolder(binding.root)

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