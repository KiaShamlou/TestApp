package com.example.testproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.data.DateManager
import com.example.testproject.date.Date
import com.example.testproject.task.AddTaskDialogActivity
import com.example.testproject.task.SearchAdapter
import com.example.testproject.task.Task
import com.example.testproject.task.TaskActivity
import com.example.testproject.task.TaskAdapter
import com.example.testproject.task.TaskDialogActivity

class SearchActivity : AppCompatActivity() {
    var taskAdapter: TaskAdapter? = null
    var searchAdapter : SearchAdapter? = null
    var resultList: ArrayList<Task> = arrayListOf()


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        var searchView = findViewById<SearchView>(R.id.search_bar)
        searchView.requestFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String): Boolean {
                resultList.removeAll { true }
                if (newText.isEmpty().not()) {
                    for (date: Date in DateManager.getDates()) {
                        for (task: Task in date.dateTasksList) {
                            if (task.title.startsWith(newText)) {
                                resultList.add(task)
                            }
                        }
                    }
                }
                //todo add these to data manager
                taskAdapter?.addAll(resultList)
                return true
            }
        })
        showTasksList()
    }

    fun showTasksList() {
        var recyclerView3 = this.findViewById<RecyclerView>(R.id.recycler_view3)

        taskAdapter = TaskAdapter(
            resultList,
            ::navigateToTaskActivity,
            ::navigateToTaskDialog,
            ::navigateToEditTaskActivity
        )
        recyclerView3.adapter = taskAdapter
        recyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    fun showDatesInside(){
        var recyclerViewSearch = this.findViewById<RecyclerView>(R.id.recycler_view_search)
        searchAdapter = SearchAdapter(
            resultList,
        )
        recyclerViewSearch.adapter = searchAdapter
        recyclerViewSearch.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    fun showDateTaskList(){
        var recyclerView3 = this.findViewById<RecyclerView>(R.id.recycler_view3)

    }


    private fun navigateToTaskDialog(task: Task) {
        var intentt = Intent(this, TaskDialogActivity::class.java)
        intentt.putExtra("Task", task)
        startActivityForResult(intentt, 101)

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

}