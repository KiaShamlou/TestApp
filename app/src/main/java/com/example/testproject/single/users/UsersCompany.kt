package com.example.testproject.single.users

import com.google.gson.annotations.SerializedName

data class UsersCompany (

    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("catchPhrase" ) var catchPhrase : String? = null,
    @SerializedName("bs"          ) var bs          : String? = null

)