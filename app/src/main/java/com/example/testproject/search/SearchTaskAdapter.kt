package com.example.testproject.search



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.task.Task

class SearchTaskAdapter(
    var dateList: MutableList<Task>,
) :

    RecyclerView.Adapter<SearchTaskAdapter.SearchTaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTaskViewHolder {
        //here we indicate that this list should show list_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_task_item, parent, false)
        return SearchTaskViewHolder(view)
    }


    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: SearchTaskViewHolder, position: Int) {
        holder.bind(dateList[position])
    }

    inner class SearchTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewDate = itemView.findViewById<TextView>(R.id.text_view_date)
        fun bind(date: Task) {

            textViewDate.text = date.title
        }
    }
}

