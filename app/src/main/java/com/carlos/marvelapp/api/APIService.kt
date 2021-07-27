package com.carlos.marvelapp.api

import com.carlos.marvelapp.models.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String
    ) : Call<Characters>
}