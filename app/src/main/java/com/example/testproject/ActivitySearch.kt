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
import com.example.testproject.search.SearchDateAdapter
import com.example.testproject.task.AddTaskDialogActivity
import com.example.testproject.task.Task
import com.example.testproject.task.TaskActivity
import com.example.testproject.task.TaskAdapter
import com.example.testproject.task.TaskDialogActivity

class SearchActivity : AppCompatActivity() {
    var searchAdapter : SearchDateAdapter? = null
    var resultList: ArrayList<Date> = arrayListOf() 


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
                if (newText.isNotEmpty()) {
                    for (date: Date in DateManager.getDates()) {
                        val resultTasks = arrayListOf<Task>()
                        for (task: Task in date.dateTasksList) {
                            if (task.title.startsWith(newText)) {
                                resultTasks.add(task)
                            }
                        }
                        if(resultTasks.isNotEmpty()){
                            resultList.add(date.copy(dateTasksList = resultTasks))
                        }
                    }
                }
                //todo add these to data manager
                searchAdapter?.addAll(resultList)
                return true
            }
        })
        showDatesInside()
    }

    fun showDatesInside() {
        var recyclerView3 = this.findViewById<RecyclerView>(R.id.recycler_view3)
        searchAdapter = SearchDateAdapter(
            resultList
        )
        recyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView3.adapter = searchAdapter
    }
}
