package com.example.testproject.single.albums.data

import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.CommentResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val postsService: PostsService
) {

    suspend fun getComments(postId: String): Flow<Resource<List<CommentResponse>>> = flow {
        emit(Resource.Loading())
        val response = postsService.getComments(postId)
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.message?:""))
    }
}