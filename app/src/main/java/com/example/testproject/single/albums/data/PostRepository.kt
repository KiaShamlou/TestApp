package com.example.testproject.single.albums.data

import androidx.lifecycle.viewModelScope
import com.example.testproject.network.ExampleJson2KtKotlin
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PostRepository @Inject constructor(
    private val postsService: PostsService
) {

    suspend fun getPosts(): Flow<Resource<List<PostResponse>>> = flow {
        emit(Resource.Loading())
        postsService.geFilan(ExampleJson2KtKotlin(
            "adasd", 12
        ))
        val response = postsService.getPostsSuspended()
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.message?:""))
    }
}
