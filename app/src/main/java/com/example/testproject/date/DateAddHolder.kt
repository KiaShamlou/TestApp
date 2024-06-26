package com.example.testproject.date

import android.app.backup.BackupManager.dataChanged
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.task.Task
import com.google.android.material.textview.MaterialTextView
class DateAddAdapter(
    var dateList: MutableList<Date>,
    val updatedData : (List<Date>) -> Unit
) :
    RecyclerView.Adapter<DateAddAdapter.DateViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAddAdapter.DateViewHolder {
    //here we indicate that this list should show list_item

    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.date_item_add, parent, false)
    return DateViewHolder(view)
}

    fun addDate(date: Date) {
        dateList.add(date)
        dataChanged()
    }
    fun dataChanged() {
        updatedData(dateList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(dateList[position], position)
    }

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val backgroundCardView = itemView.findViewById<CardView>(R.id.card_view)
        private val dateTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_date)
        private val dayTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_day)
        fun bind(date: Date, position: Int) {

            dateTextView.text = date.date.toString()
            dayTextView.text = date.day

        }

    }

}