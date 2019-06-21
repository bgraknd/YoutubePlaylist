package com.example.youtubeplaylist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// ┌──────────────────────────────────────────────┐
// |Created by Bugra on 21.06.2019 - 03:59 |
// └──────────────────────────────────────────────┘
interface ApiInterface {
    //https://www.googleapis.com/youtube/v3/
// playlists?part=snippet&channelId=UCleeGHYm74udRpj3-krDfdA&maxResults=50&key={YOUR_API_KEY}
    @GET("playlists?part=snippet")

    fun tumListeleriGetir(
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") limit: Int
    ): Call<PlaylistData>


}