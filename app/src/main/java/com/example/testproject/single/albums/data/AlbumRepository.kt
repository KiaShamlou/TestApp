package com.example.testproject.single.albums.data

import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.model.AlbumResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class AlbumRepository @Inject constructor(
    private val postsService: PostsService
): IAlbumRepository {

    override suspend fun getAlbums(userId: String): Flow<Resource<List<AlbumResponse>>> = flow {
        emit(Resource.Loading())
        val response = postsService.getAlbums(userId)
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.message?:""))
    }
}
