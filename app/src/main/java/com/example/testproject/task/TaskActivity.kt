package com.example.testproject.task

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.google.android.material.textview.MaterialTextView


//todo Kia android OS knows what activities are
class TaskActivity : AppCompatActivity() {

    //receive a Task in here and show the name of task and description
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        Log.d("TESTEST", "activity task onCreate")
        val receivedTask : Task? = intent.getParcelableExtra("TASK_NAME")
        val imageViewTask = findViewById<ImageView>(R.id.image_view_task)
        val taskActivityTitle = findViewById<MaterialTextView>(R.id.taskActivityTitle)
        val taskActivityDescription = findViewById<MaterialTextView>(R.id.taskActivityDescription)
        if (receivedTask != null) {
            imageViewTask.setBackgroundResource(receivedTask.imageId)
            taskActivityTitle.text = receivedTask.title
            taskActivityDescription.text = receivedTask.description
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("TESTEST", "activity task onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TESTEST", "activity task onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TESTEST", "activity task onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TESTEST", "activity task onDestroy")
    }
    override fun onPause() {
        super.onPause()

        Log.d("TESTEST", "activity task onPause")
    }
}
