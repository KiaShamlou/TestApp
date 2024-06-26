package com.example.testproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.date.Date
import com.example.testproject.date.DateActivity
import com.example.testproject.date.DateAdapter
import com.example.testproject.date.DateAddActivity
import com.example.testproject.task.AddTaskDialogActivity
import com.example.testproject.task.Task
import com.example.testproject.task.TaskActivity
import com.example.testproject.task.TaskAdapter
import com.example.testproject.task.TaskDialogActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textview.MaterialTextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val DELETED_TASK = "DELETED_TASK"
const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
const val VISIT_COUNT = "VISIT_COUNT"
const val TASK_LIST = "TASK_LIST"

class MainActivity : AppCompatActivity() {
    var taskAdapter: TaskAdapter? = null
    var dateAdapter : DateAdapter? = null
    var dateList : List<Date> = ArrayList()
    var tasksList : ArrayList<Task> = ArrayList()//visible list
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TESTEST", "activity main onCreate")
        tasksList = getArrayListFromPersistance()
        showDatesList()
        showTasksList()
        handleVisitCount()
        handleFab()
        val callenderImage = findViewById<ImageView>(R.id.callender_imageView)
        callenderImage.setOnClickListener(){
            navigateToDateAddActivity(dateList)
        }
    }

    fun handleFab(){
        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionBut)
        floatingButton.setOnClickListener() {
            navigateToAdddTaskActivity()
        }
    }
    private fun handleVisitCount() {
        val textViewAppOpenCount = findViewById<MaterialTextView>(R.id.text_view_app_open_count)
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        var lastVisit = sharedPref.getInt(VISIT_COUNT, 0)
        lastVisit++
        textViewAppOpenCount.text = lastVisit.toString()
        with(sharedPref.edit()) {
            putInt(VISIT_COUNT, lastVisit)
            apply()
        }
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

    private fun showDateTasks(date: Date) {
        //todo kianoosh change the visible task list to this
        tasksList = date.dateTasksList
    }

    //delete
    private fun navigateToTaskDialog(task: Task) {
        var intentt = Intent(this, TaskDialogActivity::class.java)
        intentt.putExtra("Task", task)
        startActivityForResult(intentt, 101)

    }
    private fun navigateToDateAddActivity(dateList : List<Date>) {
        val newList = ArrayList<Date>()
        dateList.forEach {
            newList.add(it)
        }
        var intentt = Intent(this, DateAddActivity::class.java)
        intentt.putParcelableArrayListExtra("dateList" , newList)
        startActivityForResult(intentt, 105)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK) {
            val deletedTask = data?.getParcelableExtra<Task>(DELETED_TASK)
            // Update UI or perform actions with the received dataString
            Toast.makeText(this, deletedTask?.title, Toast.LENGTH_LONG).show()
            if (deletedTask != null) {
                taskAdapter?.deleteTask(deletedTask)
            }
        }

        if (requestCode == 103 && resultCode == RESULT_OK) {
            val addedTask = data?.getParcelableExtra<Task>("ADDED_TASK")
            if (addedTask != null) {
                taskAdapter?.addTask(addedTask)
            }
        }

        if (requestCode == 104 && resultCode == RESULT_OK) {
            val editedTask = data?.getParcelableExtra<Task>("EDITED_TASK")
            val firstTask = data?.getParcelableExtra<Task>("FIRST_TASK")
            val position = data?.getIntExtra("POSITION", 0)
            if (editedTask != null && position != null) {
                taskAdapter?.editTask(firstTask, editedTask, position)

            }
        }
        if (requestCode == 105 && resultCode == RESULT_OK){
            val recievedDateList = arrayListOf<Date>()
            data?.getParcelableArrayListExtra<Date>("DATE_LIST")?.forEach {
                recievedDateList.add(it)
            }
            dateAdapter?.updateList(recievedDateList)
            dateList = recievedDateList
        }


    }

    private fun navigateToAdddTaskActivity() {
        var intent = Intent(this, AddTaskDialogActivity::class.java)
        startActivityForResult(intent, 103)
    }

    private fun navigateToEditTaskActivity(task: Task, position: Int) {
        var intent = Intent(this, AddTaskDialogActivity::class.java)
        intent.putExtra("TASK_NAME", task)
        intent.putExtra("POSITION", position)
        startActivityForResult(intent, 104)
    }

    private fun navigateToTaskActivity(taskName: Task) {
        var intent = Intent(this, TaskActivity::class.java)
        intent.putExtra("TASK_NAME", taskName)
        startActivity(intent)
    }

    fun showDatesList() {
        var recyclerView = this.findViewById<RecyclerView>(R.id.recycler_view)
        dateList = listOf(
            Date(date = "20", day = "Tuesday"),
            Date(date = "21", day = "Wednesday"),
            Date(date = "22", day = "Thursday"),
            Date(date = "23", day = "tuesday"),
            Date(date = "24", day = "tuesday"),
            Date(date = "25", day = "tuesday"),
        )
        //NameAdapter adapter = new NameAdapter(namesList)
        dateAdapter = DateAdapter(dateList, ::showDateTasks)
        recyclerView.adapter = dateAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }



    fun showTasksList() {
        var recyclerView2 = this.findViewById<RecyclerView>(R.id.recycler_view2)

        //NameAdapter adapter = new NameAdapter(namesList)
        taskAdapter = TaskAdapter(
            tasksList,
            ::navigateToTaskActivity,
            ::navigateToTaskDialog,
            ::navigateToEditTaskActivity,
            ::persistList
        )
        recyclerView2.adapter = taskAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun persistList(list: List<Task>) {

        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val jsonList = gson.toJson(list)
        with(sharedPref.edit()) {
            putString(TASK_LIST, jsonList)
            apply()
        }
    }

    fun getArrayListFromPersistance(): ArrayList<Task> {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPref.getString(TASK_LIST, "")
        val type = object : TypeToken<ArrayList<Task>>() {}.type
        return gson.fromJson(json, type) ?: ArrayList()
    }
}
