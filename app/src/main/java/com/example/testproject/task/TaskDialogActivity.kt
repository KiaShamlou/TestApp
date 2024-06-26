package com.example.testproject.task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.DELETED_TASK
import com.example.testproject.MainActivity
import com.example.testproject.R


class TaskDialogActivity: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.task_dialog)
        Log.d("TESTEST", "activity task onCreate")
        val receivedTask: Task? = intent.getParcelableExtra("Task")
        val button = findViewById<Button>(R.id.okButton)
        val cancelButton = findViewById<Button>(R.id.exitButton)
        val title = findViewById<TextView>(R.id.text_view_title_dialog)
        if (receivedTask != null) {
            title.text = resources.getString(R.string.delete_task, receivedTask.title)
        }
        button.setOnClickListener(){
            if(receivedTask!=null) {
                navigateToMainActivityNDelete(receivedTask)
            }
        }
        cancelButton.setOnClickListener(){
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivityNDelete(task: Task){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra(DELETED_TASK,task)
        setResult(RESULT_OK,intent)
        finish()
    }
    private fun navigateToMainActivity(){
        var intent = Intent(this, MainActivity::class.java)
        setResult(RESULT_CANCELED,intent)
        finish()
    }
}
