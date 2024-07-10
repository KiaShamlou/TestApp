package com.example.testproject.single

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TESTEST", "SingleActivity")
        setContentView(R.layout.activity_single)

    }
}
