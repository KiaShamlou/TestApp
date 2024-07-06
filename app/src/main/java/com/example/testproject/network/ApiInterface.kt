package com.example.testproject.network

import com.example.testproject.network.model.LaptopResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET


interface ApiInterface {
    @GET("/objects")
    fun getLaptopModel(): Call<List<LaptopResponse>>
}
