package com.example.testproject.network.model

import com.google.gson.annotations.SerializedName


data class LaptopResponse (

  @SerializedName("id"   ) var id   : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("data" ) var data : LaptopDataResponse?   = LaptopDataResponse()

)
