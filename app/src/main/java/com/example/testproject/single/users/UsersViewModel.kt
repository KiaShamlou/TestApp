package com.example.testproject.single.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testproject.network.PostsService
import com.example.testproject.network.model.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val postsService: PostsService
) : ViewModel() {

    var loading = MutableLiveData<Boolean>(false)
    var user = MutableLiveData<UserResponse>()
    fun getUser(userId: String) {
        if(user.value != null)return
        loading.value = true
        val call = postsService.getUser(userId)
        call?.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let{
                        loading.value = false
                        user.value = it
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()

                loading.value = false

            }
        }
        )
    }

}