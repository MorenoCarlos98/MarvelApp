package com.carlos.marvelapp

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/v1/public/characters")
    fun getCharacters(): Response<List<Superheroe>>
}