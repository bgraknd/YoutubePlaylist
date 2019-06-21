package com.example.youtubeplaylist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyDVbgiROZyU0eb1Eb23YBqacEhojamNS38"
    val CHANNEL_ID = "UCleeGHYm74udRpj3-krDfdA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        var apiCall = apiInterface?.tumListeleriGetir(CHANNEL_ID, API_KEY, 50)

        apiCall?.enqueue(object : Callback<PlaylistData> {

            override fun onFailure(call: Call<PlaylistData>, t: Throwable) {
                Log.e("Hata !", "" + t?.printStackTrace())

            }

            override fun onResponse(call: Call<PlaylistData>, response: Response<PlaylistData>) {
                Log.e("Basarili !", "" + call?.request()?.url()?.toString())

                for (i in 0..response?.body()?.items?.size!!-1)
                Log.e("Basarili !", "" + response?.body()?.items?.get(i)?.snippet?.title)

            }

        })

    }
}
