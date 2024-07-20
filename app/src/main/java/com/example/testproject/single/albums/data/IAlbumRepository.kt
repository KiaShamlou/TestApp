package com.example.testproject.single.albums.data

import com.example.testproject.network.Resource
import com.example.testproject.network.model.AlbumResponse
import kotlinx.coroutines.flow.Flow

interface IAlbumRepository {

    suspend fun getAlbums(userId: String): Flow<Resource<List<AlbumResponse>>>
}
