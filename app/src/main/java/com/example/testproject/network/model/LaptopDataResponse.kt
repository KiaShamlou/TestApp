package com.example.testproject.network.model

import com.google.gson.annotations.SerializedName


data class LaptopDataResponse(

    @SerializedName("year") var year: Int? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("CPU    model") var cpuModel: String? = null,
    @SerializedName("Hard   disk   size") var diskSize: String? = null

)
