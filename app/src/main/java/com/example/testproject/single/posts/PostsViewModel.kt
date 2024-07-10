package com.example.testproject.single.posts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.network.PostsService
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.PostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class PostsViewModel @Inject constructor(
    private val postsService: PostsService
): ViewModel() {

    var list = MutableLiveData<List<PostResponse>>(listOf())
    var loading = MutableLiveData<Boolean>(false)
    init {

        getPosts()
    }
    fun getPosts(){

        Log.d("TESTEST", "get posts called")
        loading.value = true
        val call = postsService.getPosts()
        call.enqueue(object : Callback<List<PostResponse>> {
            override fun onResponse(call: Call<List<PostResponse>>, response: Response<List<PostResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        loading.value = false
                        list.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                t.printStackTrace()

                loading.value = false

            }
        }
        )
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("TESTEST", "oncleared")
    }
}
