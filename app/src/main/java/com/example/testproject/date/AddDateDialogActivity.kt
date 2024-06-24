package com.example.testproject.date

import com.example.testproject.task.Task


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.MainActivity
import com.example.testproject.R

class AddDateDialogActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false)
        setContentView(R.layout.add_date_dialog)
        val addButton = findViewById<Button>(R.id.addButton_date)
        val cancelButton = findViewById<Button>(R.id.exitButtonDia_date)
        val addDayEdit = findViewById<EditText>(R.id.edit_text_day)
        val addDateEdit = findViewById<EditText>(R.id.dateboxDate)

        addButton.setOnClickListener() {
            val createdDate: Date =
                Date(
                    day = addDayEdit.text.toString(),
                    date = addDateEdit.text.toString()
                )
            navigateToDateActivityNAdd(createdDate)
        }
        cancelButton.setOnClickListener() {
            navigateToMainActivity()
        }
    }


private fun navigateToDateActivityNAdd(date: Date) {
    var intent = Intent(this, DateAddActivity::class.java)
    intent.putExtra("ADDED_DATE", date)
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
    var intent = Intent(this, DateAddActivity::class.java)
    setResult(RESULT_CANCELED, intent)
    finish()
}
}
