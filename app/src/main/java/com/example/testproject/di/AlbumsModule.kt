package com.example.testproject.di

import com.example.testproject.single.albums.data.AlbumRepository
import com.example.testproject.single.albums.data.IAlbumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AlbumsModule {

    @Binds
    abstract fun bindAlbumsRepository(
        albumRepository: AlbumRepository
    ): IAlbumRepository
}
