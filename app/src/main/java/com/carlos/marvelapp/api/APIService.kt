package com.carlos.marvelapp.api

import com.carlos.marvelapp.models.Character
import com.carlos.marvelapp.models.Comic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String
    ) : Call<Character>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComics(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String
    ) : Call<Comic>
}