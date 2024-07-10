package com.example.testproject.data

import android.content.Context
import android.content.SharedPreferences
import com.example.testproject.DATE_LIST
import com.example.testproject.SHARED_PREF_NAME
import com.example.testproject.date.Date
import com.example.testproject.task.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
 object DateManager {
    private var sharedPreferences: SharedPreferences? = null
    private var dateList : List<Date> = ArrayList()

    //called when activity created
    fun init(sharedPreferences: SharedPreferences){
        this.sharedPreferences = sharedPreferences
        this.dateList = getDateListFromPersistance()
    }

    fun isDatesEmpty(): Boolean{
        return dateList.isEmpty()
    }
    fun getDates(): List<Date>{
        return dateList
    }
    fun taskEdited(editedTask: Task? , position: Int){
        if(editedTask != null){
            val prevList = getCurrentTaskList()
            prevList[position] = editedTask
        }
        persistDateList()
    }
    fun taskDeleted(addedTask: Task?){
        getCurrentTaskList().remove(addedTask)
        persistDateList()
    }
    fun taskAdded(addedTask: Task?) {
        if (addedTask != null) {
            val prevList = getCurrentTaskList()
            prevList.add(addedTask)
        }
        persistDateList()
    }
    fun getCurrentTaskList(): ArrayList<Task>{
        val selectedDate = dateList.find { it.isSelected }
        return selectedDate?.dateTasksList?: arrayListOf()
    }
    fun dateListAdded(list : List<Date>){
        dateList = list
        dateList[0].isSelected = true
    }


    fun persistDateList() {
        val gson = Gson()
        val jsonList = gson.toJson(dateList)
        sharedPreferences?.edit()?.run {
            putString(DATE_LIST, jsonList)
            apply()
        }
    }

    fun getDateListFromPersistance(): ArrayList<Date> {
        val gson = Gson()
        val json = sharedPreferences?.getString(DATE_LIST, "")
        val type = object : TypeToken<ArrayList<Date>>() {}.type
        return gson.fromJson(json, type) ?: ArrayList()
    }
}
