package com.arash.applikatask.ui.arz

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arash.applikatask.databinding.RecyclerItemArzBinding
import com.arash.applikatask.model.localdbmodel.DbModel
import java.util.*
import kotlin.collections.ArrayList

class ArzAdapter(listmain : List<DbModel>) : ListAdapter<DbModel, ArzAdapter.TodayViewHolder>(TodayDiffUtil()),Filterable {


    var list: List<DbModel> = listmain
    var listFilter: List<DbModel> = listmain

    init {
        list = listmain
        listFilter = listmain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val binding = RecyclerItemArzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayViewHolder(binding)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {

        holder.binding.data = listFilter[position]

    }

    class TodayViewHolder(val binding: RecyclerItemArzBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return listFilter.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                if (charString.isEmpty()) {
                    listFilter = list
                } else {
                    val filteredList: MutableList<DbModel> = ArrayList()

                    for (row in list) {

                        val all: String = row.Name

                        if (all.toLowerCase(Locale.ROOT).contains(charString.toLowerCase(Locale.ROOT))
                        ) {
                            filteredList.add(row)
                        }
                    }
                    listFilter = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = listFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                listFilter = results.values as ArrayList<DbModel>
                notifyDataSetChanged()
            }
        }
    }
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