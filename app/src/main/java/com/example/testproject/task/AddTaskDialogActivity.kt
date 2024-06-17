package com.example.testproject.task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.MainActivity
import com.example.testproject.R

class AddTaskDialogActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.add_task_activity)
        val addButton = findViewById<Button>(R.id.addButton)
        val cancelButton = findViewById<Button>(R.id.exitButtonDia)
        val addDescEdit = findViewById<EditText>(R.id.edit_text_desc)
        val addTitleEdit = findViewById<EditText>(R.id.textboxName)

        addButton.setOnClickListener(){
            val createdTask : Task =
                Task(title = addTitleEdit.text.toString(), description = addDescEdit.text.toString(), imageId = R.drawable.fourth)
            navigateToMainActivityNAdd(createdTask)
        }
        cancelButton.setOnClickListener(){
            navigateToMainActivity()
        }
    }
    private fun navigateToMainActivityNAdd(task: Task){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ADDED_TASK",task)
        setResult(RESULT_OK,intent)
        finish()
    }
    private fun navigateToMainActivity(){
        var intent = Intent(this, MainActivity::class.java)
        setResult(RESULT_CANCELED,intent)
        finish()
    }
}