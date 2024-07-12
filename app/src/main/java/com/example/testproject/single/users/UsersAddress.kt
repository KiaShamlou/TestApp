package com.example.testproject.single.users

import com.google.gson.annotations.SerializedName


data class UsersAddress (

    @SerializedName("street"  ) var street  : String? = null,
    @SerializedName("suite"   ) var suite   : String? = null,
    @SerializedName("city"    ) var city    : String? = null,
    @SerializedName("zipcode" ) var zipcode : String? = null,
    @SerializedName("geo"     ) var geo     : UsersGeo?    = UsersGeo()

)