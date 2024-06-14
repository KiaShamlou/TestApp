package com.example.testproject.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
//todo Kia android OS knows what activities are
class TaskActivity : AppCompatActivity() {

    //receive a Task in here and show the name of task and description
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)



    }
}
