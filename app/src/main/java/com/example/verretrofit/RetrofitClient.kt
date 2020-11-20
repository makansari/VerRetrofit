package com.example.verretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterface{

    @GET("users")
    fun getUsers() : Call<List<Users>>
}


class RetrofitClient {

    companion object{

        val  myRetrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myApiInterface = myRetrofit.create(ApiInterface::class.java)
        val myCall :Call<List<Users>> = myApiInterface.getUsers()
    }
}