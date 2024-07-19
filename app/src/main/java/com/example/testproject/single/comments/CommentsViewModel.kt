package com.example.testproject.single.comments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.AlbumResponse
import com.example.testproject.network.model.CommentResponse
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.example.testproject.single.albums.data.AlbumRepository
import com.example.testproject.single.albums.data.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val commentRepository: CommentRepository
): ViewModel() {

    var comments = MutableStateFlow<Resource<List<CommentResponse>>>(Resource.Loading())

    fun getComments(userId: String){
        viewModelScope.launch {
            commentRepository.getComments(userId).collect {
                comments.value = it
            }
        }
    }

}
