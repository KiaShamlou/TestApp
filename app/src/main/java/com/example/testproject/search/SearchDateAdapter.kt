package com.example.testproject.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.date.Date

class SearchDateAdapter(
    var dateList: MutableList<Date>,
) :

    RecyclerView.Adapter<SearchDateAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        //here we indicate that this list should show list_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return SearchViewHolder(view)
    }

    fun addAll(dateList: MutableList<Date>){
        this.dateList = dateList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(dateList[position], position)
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tasksRecyclerView = itemView.findViewById<RecyclerView>(R.id.recycler_view_search)
        fun bind(date: Date, position: Int) {
            val searchTaskAdapter = SearchTaskAdapter(date.dateTasksList)
            tasksRecyclerView.adapter = searchTaskAdapter
        }
    }
}
