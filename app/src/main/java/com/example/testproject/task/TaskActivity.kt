package com.example.testproject.task

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.R
import com.google.android.material.textview.MaterialTextView

class TaskActivity : AppCompatActivity() {

    //receive a Task in here and show the name of task and description


    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)


        Log.d("TESTEST", "activity task onCreate")
        val receivedTask : Task? = intent.getParcelableExtra("TASK_NAME")
        val taskActivityTitle = findViewById<MaterialTextView>(R.id.taskActivityTitle)
        val taskActivityDescription = findViewById<MaterialTextView>(R.id.taskActivityDescription)
        val buttonIncreaseNumber = findViewById<Button>(R.id.button_increase_number)
        val textViewCount = findViewById<TextView>(R.id.text_view_count)
        count = savedInstanceState?.getInt("COUNT")?:0
        textViewCount.text = count.toString()
        buttonIncreaseNumber.setOnClickListener {
            count++
            textViewCount.text = count.toString()
        }


        if (receivedTask != null) {
            taskActivityTitle.text = receivedTask.title
            taskActivityDescription.text = receivedTask.description
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT", count)

        Log.d("TESTEST", "onSaveInstanceState")
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


fun main() {

    findPairs(listOf(1,2,4,3,5,2), 4)
}



fun findPairs(list: List<Int>, target: Int){
    var i = 0
    while (i < list.size){
        var j = 0
        while (j < list.size){

            if(list[i]+ list[j] == target){
                print(list[i])
                println(list[j])
            }
            j++
        }
        i++
    }
}
//n
//n^2

fun print(list: List<Int>) {
    var i = 0
    while (i < list.size){
        println(list[i])
        i++
    }
    while (i < list.size){
        println(list[i])
        i++
    }
    while (i < list.size){
        println(list[i])
        i++
    }
}
fun printPairs(list: List<Int>){

    var i = 0
    while (i < list.size){
        var j = 0
        while (j < list.size){

            print(list[i])
            println(list[j])
            j++
        }
        i++
    }
}
