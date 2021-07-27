package com.carlos.marvelapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val BASE_URL = "https://gateway.marvel.com"

    val retrofitService: APIService by lazy {
        getRetrofit().create(APIService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}