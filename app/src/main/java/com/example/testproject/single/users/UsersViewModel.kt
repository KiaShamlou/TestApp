package com.example.testproject.single.users

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.network.PostsService
import com.example.testproject.network.Resource
import com.example.testproject.network.RetrofitInstance
import com.example.testproject.network.model.PostResponse
import com.example.testproject.network.model.UserResponse
import com.example.testproject.single.albums.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    var users = MutableStateFlow<Resource<List<UserResponse>>>(Resource.Loading())

    init {
        getUsers()
    }
    fun getUsers(){
        viewModelScope.launch {
            userRepository.getUsers().collect {
                users.value = it
            }
        }
    }
}
