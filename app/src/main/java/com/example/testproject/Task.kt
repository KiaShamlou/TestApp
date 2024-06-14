package com.example.testproject


data class Task(
    var title: String,
    var description:String,
    var imageId : Int=R.drawable.first,
    var isSelected : Boolean = false
)