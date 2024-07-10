package com.example.testproject.network

import com.example.testproject.network.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET


interface PostsService {
    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>


}
