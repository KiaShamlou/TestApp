package com.example.testproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.task.Task
import com.example.testproject.task.TaskActivity
import com.example.testproject.task.TaskAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TESTEST", "activity main onCreate")
        showDatesList()
        showTasksList()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TESTEST", "activity main onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TESTEST", "activity main onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TESTEST", "activity main onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TESTEST", "activity main onDestroy")
    }
    override fun onPause() {
        super.onPause()

        Log.d("TESTEST", "activity main onPause")
    }

    private fun navigateToTaskActivity(taskName: Task){
        var intent = Intent(this, TaskActivity::class.java)
        intent.putExtra("TASK_NAME", taskName)
        startActivity(intent)
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
        var adapter2 = TaskAdapter(tasksList, ::navigateToTaskActivity)
        recyclerView2.adapter = adapter2
        //a new adapter
        //a data class
        //
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
