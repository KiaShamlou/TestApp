package com.example.testproject.single.albums

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.single.albums.data.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val albumRepository: AlbumRepository
): ViewModel() {

    var albums = MutableStateFlow<Resource<List<AlbumResponse>>>(Resource.Loading())

    fun getAlbums(userId: String){
        viewModelScope.launch {
            albumRepository.getAlbums(userId).collect {
                albums.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        Log.d("TESTEST", "oncleared")
    }
}
