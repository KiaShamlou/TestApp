package com.example.testproject.date

import android.os.Parcel
import android.os.Parcelable
import com.example.testproject.task.Task
import kotlinx.parcelize.Parcelize

@Parcelize
data class Date(
    var day: String,
    var date: Int,
    var isSelected : Boolean = false,
    var dateTasksList : ArrayList<Task> = arrayListOf()
    //todo kianoosh add list of tasks
):Parcelable
