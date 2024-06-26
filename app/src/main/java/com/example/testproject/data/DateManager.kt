package com.example.testproject.data

import com.example.testproject.date.Date
import com.example.testproject.task.Task

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
    }
}
