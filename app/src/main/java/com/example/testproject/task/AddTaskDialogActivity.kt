package com.example.testproject.task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.testproject.MainActivity
import com.example.testproject.R

class AddTaskDialogActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false)
        setContentView(R.layout.add_task_activity)
        val receivedTask: Task? = intent.getParcelableExtra("TASK_NAME")
        val receivedPos: Int = intent.getIntExtra("POSITION", 0)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.isEnabled = false
        val cancelButton = findViewById<Button>(R.id.exitButtonDia)
        val addDescEdit = findViewById<EditText>(R.id.edit_text_desc)
        val addTitleEdit = findViewById<EditText>(R.id.textboxName)

        if (receivedTask == null) {
            addButton.isEnabled = true
            Toast.makeText(this, "ya ali", Toast.LENGTH_LONG).show()
            addButton.setOnClickListener() {
                val createdTask: Task =
                    Task(
                        title = addTitleEdit.text.toString(),
                        description = addDescEdit.text.toString(),
                        imageId = R.drawable.fourth
                    )
                navigateToMainActivityNAdd(createdTask)
            }
            cancelButton.setOnClickListener() {
                navigateToMainActivity()
            }
        } else {
            addTitleEdit.setText(receivedTask.title.toString())
            addTitleEdit.addTextChangedListener() {
                addButton.isEnabled = addTitleEdit.text.toString() != receivedTask?.title.toString()
            }
            addButton.setOnClickListener() {
                val EditedTask: Task = Task(
                    title = addTitleEdit.text.toString(),
                    description = addDescEdit.text.toString(),
                    imageId = R.drawable.fourth
                )
                navigateToMainActivityEdit(receivedTask, EditedTask, receivedPos)
            }
            cancelButton.setOnClickListener() {
                navigateToMainActivity()
            }
        }
    }

    private fun navigateToMainActivityNAdd(task: Task) {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ADDED_TASK", task)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun navigateToMainActivityEdit(receivedTask: Task, EditedTask: Task, position: Int) {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("FIRST_TASK", receivedTask)
        intent.putExtra("EDITED_TASK", EditedTask)
        intent.putExtra("POSITION", position)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun navigateToMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        setResult(RESULT_CANCELED, intent)
        finish()
    }
}