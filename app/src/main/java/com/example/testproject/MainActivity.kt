package com.example.testproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        var recyclerView = this.findViewById<RecyclerView>(R.id.recycler_view)
        var dateList = listOf(
            Date(date = 20 , day = "Tuesday"),
            Date(date = 21 , day = "Wednesday"),
            Date(date = 22 , day = "Thursday" , isSelected = true),
            Date(date = 23 , day = "tuesday"),
            Date(date = 24 , day = "tuesday"),
            Date(date = 25 , day = "tuesday"),
        )
        //NameAdapter adapter = new NameAdapter(namesList)
        var adapter = DateAdapter(dateList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)






        var recyclerView2 = this.findViewById<RecyclerView>(R.id.recycler_view2)
        var tasksList = listOf(
            Task(title = "Idea" , description = "This is an idea"),
            Task(title = "Food" , description = "This is a food"),
            Task(title = "Work" , description = "This is a work"),
            Task(title = "Sport" , description = "This is a sport"),
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
