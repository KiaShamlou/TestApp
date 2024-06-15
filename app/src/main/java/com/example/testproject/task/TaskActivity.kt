package com.example.testproject.task

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
//todo Kia android OS knows what activities are
class TaskActivity : AppCompatActivity() {

    //receive a Task in here and show the name of task and description
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        Log.d("TESTEST", "activity task onCreate")
        val receivedTask : Task? = intent.getParcelableExtra("TASK_NAME")
        Toast.makeText(this, receivedTask?.title, Toast.LENGTH_LONG).show()
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
