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


class TaskAdapter(var taskList: MutableList<Task>, val onClick: (Task) -> Unit, val onLongClick: (Task) -> Unit, val onClickEdit: (Task, Int) -> Unit) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    fun deleteTask(task: Task) {
        taskList.removeIf { it.title == task.title }
        notifyDataSetChanged()
    }
    fun addTask(task : Task){
        taskList.add(task)
        notifyDataSetChanged()
    }
    fun editTask(firstTask : Task?,editedTask: Task,position: Int){
        taskList[position] = editedTask
        notifyDataSetChanged()
    }

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

        val taskImageView: ImageView = itemView.findViewById(R.id.image_view_task)
        var titleTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_title)
        var descriptionTextView = itemView.findViewById<MaterialTextView>(R.id.text_view_description)
        var kebabBo = itemView.findViewById<Button>(R.id.button_kebab)

        fun bind(task: Task, position: Int) {
            Glide
                .with(itemView.context)
                .load("https://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/nebula_brown.png")
                .centerCrop()
                .placeholder(R.drawable.fourth)
                .into(taskImageView)
            titleTextView.text = task.title
            descriptionTextView.text = task.description

            itemView.setOnClickListener {

                onClick(task)
            }
            itemView.setOnLongClickListener {
                onLongClick(task)
                true
            }
            kebabBo.setOnClickListener(){
                onClickEdit(task,position)

            }


        }


    }
}
