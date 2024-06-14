package com.example.testproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView


class TaskAdapter(val taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        //here we indicate that this list should show list_item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }


    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position], position)
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskImageView : ImageView = itemView.findViewById(R.id.image_view_task)
        var titleTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_title)
        var descriptionTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_description)

        fun bind(task: Task, position: Int) {
            taskImageView.setBackgroundResource(task.imageId)
            titleTextView.text = task.title
            descriptionTextView.text = task.description


        }
    }
}
