package com.example.testproject.single.albums.data

import androidx.lifecycle.viewModelScope
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

class UserRepository @Inject constructor(
    private val postsService: PostsService
) {

    suspend fun getUsers(): Flow<Resource<List<UserResponse>>> = flow {
        emit(Resource.Loading())
        val response = postsService.getUsersSuspended()
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.message?:""))
    }
}