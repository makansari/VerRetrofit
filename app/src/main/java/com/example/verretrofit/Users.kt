package com.example.verretrofit

import com.google.gson.annotations.SerializedName

data class Users(var id : Int, var name : String,@SerializedName ("username") var uname : String   ) {
}