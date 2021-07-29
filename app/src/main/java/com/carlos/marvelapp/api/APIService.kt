package com.carlos.marvelapp.api

import com.carlos.marvelapp.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    //Llamada a obtener todos los personajes
    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String,
        @Query("limit")limit:Int
    ) : Call<Character>

    //Llamada a obtener los comics del personaje escogido
    @GET("/v1/public/characters/{characterId}/comics")
    fun getComics(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String,
        @Query("limit")limit:Int
    ) : Call<Comic>

    //Llamada a obtener las series del personaje escogido
    @GET("/v1/public/characters/{characterId}/series")
    fun getSeries(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String,
        @Query("limit")limit:Int
    ) : Call<Serie>

    //Llamada a obtener las historias del personaje escogido
    @GET("/v1/public/characters/{characterId}/stories")
    fun getStories(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String,
        @Query("limit")limit:Int
    ) : Call<Story>

    //Llamada a obtener los eventos del personaje escogido
    @GET("/v1/public/characters/{characterId}/events")
    fun getEvents(
        @Path("characterId") characterId: String,
        @Query("ts") ts: String,
        @Query("apikey")apikey: String,
        @Query("hash")hash: String,
        @Query("limit")limit:Int
    ) : Call<Event>
}