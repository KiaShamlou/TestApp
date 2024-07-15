package com.example.testproject.network

import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PostsService {
    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>
    @GET("users")
    fun getUsers(): Call<List<UserResponse>>
    @GET("/comments")
    fun getComments(
        @Query("postId") postId: String
    ): Call<List<CommentResponse>>


}
