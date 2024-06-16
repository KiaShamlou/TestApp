package com.example.testproject.date

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.example.testproject.task.Task
import com.google.android.material.textview.MaterialTextView

class DateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        Log.d("TESTEST", "activity task onCreate")
        val receivedDate : Date? = intent.getParcelableExtra("DATE_NAME")
        val activityDateActivityTitle = findViewById<MaterialTextView>(R.id.activity_text_view_day)
        val activityDayActivityDescription = findViewById<MaterialTextView>(R.id.activity_text_view_date)
        if (receivedDate != null) {
            activityDateActivityTitle.text = receivedDate.day
            activityDayActivityDescription.text = receivedDate.date.toString()
        }
    }
}
