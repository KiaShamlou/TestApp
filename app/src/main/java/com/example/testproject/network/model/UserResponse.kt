package com.example.testproject.network.model

import com.example.testproject.single.users.UsersAddress
import com.example.testproject.single.users.UsersCompany
import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("id"       ) var id       : Int?     = null,
    @SerializedName("name"     ) var name     : String?  = null,
    @SerializedName("username" ) var username : String?  = null,
    @SerializedName("email"    ) var email    : String?  = null,
    @SerializedName("address"  ) var address  : UsersAddress? = UsersAddress(),
    @SerializedName("phone"    ) var phone    : String?  = null,
    @SerializedName("website"  ) var website  : String?  = null,
    @SerializedName("company"  ) var company  : UsersCompany? = UsersCompany()
    )