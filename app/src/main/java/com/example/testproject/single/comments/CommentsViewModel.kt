package com.example.testproject.single.comments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.network.PostsService
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val postsService: PostsService
): ViewModel() {

    var commentsList = MutableLiveData<List<CommentResponse>>(listOf())
    var loading = MutableLiveData<Boolean>(false)
//    var post = MutableLiveData<PostResponse>()
    fun getComments(postId: String){
//        if(list.value != null)return
        loading.value = true
        val call = postsService.getComments(postId)
        call.enqueue(object : Callback<List<CommentResponse>> {
            override fun onResponse(call: Call<List<CommentResponse>>, response: Response<List<CommentResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        loading.value = false
                        commentsList.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<CommentResponse>>, t: Throwable) {
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
