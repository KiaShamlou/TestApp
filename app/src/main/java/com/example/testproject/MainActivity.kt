package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.task.TaskActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDatesList()
        showTasksList()
        handleButtonClicks()
    }

    private fun handleButtonClicks(){

        val button = findViewById<MaterialButton>(R.id.button_go_to_task)

        button.setOnClickListener {
            var intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }

    }
    private fun showDatesList() {
        var recyclerView = this.findViewById<RecyclerView>(R.id.recycler_view)
        var dateList = listOf(
            Date(date = 20, day = "Tuesday"),
            Date(date = 21, day = "Wednesday"),
            Date(date = 22, day = "Thursday"),
            Date(date = 23, day = "tuesday"),
            Date(date = 24, day = "tuesday"),
            Date(date = 25, day = "tuesday"),
        )
        //NameAdapter adapter = new NameAdapter(namesList)
        var adapter = DateAdapter(dateList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun showTasksList() {
        var recyclerView2 = this.findViewById<RecyclerView>(R.id.recycler_view2)
        var tasksList = listOf(
            Task(title = "Idea", description = "This is an idea", imageId = R.drawable.first),
            Task(title = "Food", description = "This is a food", imageId = R.drawable.second),
            Task(title = "Work", description = "This is a work", imageId = R.drawable.third),
            Task(title = "Sport", description = "This is a sport", imageId = R.drawable.fourth),
        )
        //NameAdapter adapter = new NameAdapter(namesList)
        var adapter2 = TaskAdapter(tasksList)
        recyclerView2.adapter = adapter2
        //a new adapter
        //a data class
        //
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
