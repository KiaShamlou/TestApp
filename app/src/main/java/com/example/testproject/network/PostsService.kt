package com.example.testproject.network

import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
//hey this is from main branch
interface PostsService {

    @GET("users")
    suspend fun getUsersSuspended(): List<UserResponse>

    @GET("/comments")
    suspend fun getComments(
        @Query("postId") postId: String
    ): List<CommentResponse>

    @GET("albums")
    suspend fun getAlbums(
        @Query("userId") userId: String
    ): List<AlbumResponse>

    @GET("posts")
    suspend fun getPostsSuspended(): List<PostResponse>


    @POST("/asdad")
    suspend fun geFilan(@Body request: ExampleJson2KtKotlin)
}


data class ExampleJson2KtKotlin (

    @SerializedName("userAgentType"  ) var userAgentType  : String? = null,
    @SerializedName("currentVersion" ) var currentVersion : Int?    = null

)
