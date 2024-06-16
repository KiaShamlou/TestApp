package com.example.testproject.task

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.MainActivity
import com.example.testproject.R

class TaskDialogActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.task_dialog)
        Log.d("TESTEST", "activity task onCreate")
        val receivedTask: Task? = intent.getParcelableExtra("Task")
        val button = findViewById<Button>(R.id.okButton)
        button.setOnClickListener(){
            if(receivedTask!=null) {
                navigateToMainActivity(receivedTask)
            }
        }
    }

    private fun navigateToMainActivity(task: Task){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("DELETED_TASK",task)
        setResult(RESULT_OK,intent)
        finish()
    }
}