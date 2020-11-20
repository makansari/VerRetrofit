package com.example.verretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var makeCall = RetrofitClient.myCall

        makeCall.enqueue(object : Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                var myUsers : List<Users>? = response.body()!!
                var myStringBuilder = StringBuilder()

               if (myUsers != null) {
                    for(user in myUsers){
                        myStringBuilder.append(user.id)
                        myStringBuilder.append("\n")
                        myStringBuilder.append(user.name)
                        myStringBuilder.append("\n")
                        myStringBuilder.append(user.uname)
                        myStringBuilder.append("\n")

                        myStringBuilder.append("\n")
                        myStringBuilder.append("\n")

                    }
                }

                textViewResult.setText(myStringBuilder)


            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
            }

        })
    }
}