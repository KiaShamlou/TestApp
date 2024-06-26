package com.example.testproject.task

import android.os.Parcelable
import com.example.testproject.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var title: String,
    var description:String,
    var imageId : Int= R.drawable.first,
    var isSelected : Boolean = false
): Parcelable
