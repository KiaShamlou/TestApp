package com.example.testproject.network.model
import com.google.gson.annotations.SerializedName


data class AlbumResponse (

    @SerializedName("userId" ) var userId : Int?    = null,
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null

)