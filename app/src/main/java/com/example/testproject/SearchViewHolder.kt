package com.example.testproject.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testproject.R
import com.google.android.material.textview.MaterialTextView
class SearchAdapter(
    var taskList: MutableList<Task>,
) :

    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        //here we indicate that this list should show list_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_item, parent, false)
        return SearchViewHolder(view)
    }


    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(taskList[position], position)
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val taskImageView: ImageView = itemView.findViewById(R.id.image_view_task)

        fun bind(task: Task, position: Int) {
            Glide
                .with(itemView.context)
                .load("https://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/nebula_brown.png")
                .centerCrop()
                .placeholder(R.drawable.fourth)
                .into(taskImageView)
            titleTextView.text = task.title
            descriptionTextView.text = task.description



        }


    }
}
