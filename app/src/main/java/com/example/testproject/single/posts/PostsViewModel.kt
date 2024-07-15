package com.example.testproject.single.posts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.PostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsService: PostsService
): ViewModel() {

    var posts = MutableStateFlow<Resource<List<PostResponse>>>(Resource.Loading())

    init {

        getPosts()
    }

    private fun getPosts(){
        viewModelScope.launch {
            try {
                posts.value = Resource.Loading()
                val response = postsService.getPostsSuspended()
                posts.value = Resource.Success(response)
            }catch (e: Exception){

                posts.value = Resource.Error(e.localizedMessage)
            }

        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("TESTEST", "oncleared")
    }
}
