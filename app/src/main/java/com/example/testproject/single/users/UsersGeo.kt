package com.example.testproject.single.users

import com.google.gson.annotations.SerializedName


data class UsersGeo (

    @SerializedName("lat" ) var lat : String? = null,
    @SerializedName("lng" ) var lng : String? = null

)