package com.example.testproject.network

import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



//hey this is from main branch
interface PostsService {

    @GET("users")
    fun getUsers(): Call<List<UserResponse>>

    @GET("/comments")
    fun getComments(
        @Query("postId") postId: String
    ): Call<List<CommentResponse>>

    @GET("albums")
    suspend fun getAlbums(
        @Query("userId") userId: String
    ): List<AlbumResponse>

    @GET("posts")
    suspend fun getPostsSuspended(): List<PostResponse>
}
