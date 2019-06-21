package com.example.youtubeplaylist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// ┌──────────────────────────────────────────────┐
// |Created by Bugra on 21.06.2019 - 03:46 |
// └──────────────────────────────────────────────┘
object ApiClient {

    val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }


}