package com.carlos.marvelapp.api

import com.carlos.marvelapp.utils.constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val instance: APIService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        instance = retrofit.create(APIService::class.java)
    }
}