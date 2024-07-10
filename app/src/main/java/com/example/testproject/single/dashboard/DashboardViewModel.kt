package com.example.testproject.single.dashboard

import androidx.lifecycle.ViewModel
import com.example.testproject.network.PostsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel@Inject constructor(
    private val postsService: PostsService
) : ViewModel() {


    var a = 1

}
