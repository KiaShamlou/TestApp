package com.example.testproject.data

import android.content.Context
import com.example.testproject.SHARED_PREF_NAME
import com.example.testproject.TASK_LIST
import com.example.testproject.date.Date
import com.example.testproject.task.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
const val DATE_LIST = "DATE_LIST"

class DateManager {

    var dateList : List<Date> = ArrayList()

    fun taskEdited(editedTask: Task? , position: Int){
        if(editedTask != null){
            val prevList = getCurrentTaskList()
            prevList[position] = editedTask
        }
    }
    fun taskDeleted(addedTask: Task?){
        getCurrentTaskList().remove(addedTask)
    }
    fun taskAdded(addedTask: Task?) {
        if (addedTask != null) {
            val prevList = getCurrentTaskList()
            prevList.add(addedTask)
        }
    }
    fun getCurrentTaskList(): ArrayList<Task>{
        val selectedDate = dateList.find { it.isSelected }
        return selectedDate?.dateTasksList?: arrayListOf()
    }
    fun dateListAdded(list : List<Date>){
        dateList = list
        dateList[0].isSelected = true
    }


}
