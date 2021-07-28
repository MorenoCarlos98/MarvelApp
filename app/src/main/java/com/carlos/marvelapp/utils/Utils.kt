package com.carlos.marvelapp.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.adapters.*
import com.carlos.marvelapp.api.API
import com.carlos.marvelapp.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Utils {
    companion object {
        //Credenciales para poder usar API:

        const val BASE_URL = "https://gateway.marvel.com"
        const val ts = "1"
        const val apikey:String = "dadded75ae894f33f3fd530f104ce724"
        const val hash:String = "2618ce007444e5a5699ebb24b4c4f95b"

        //Funciones de la obtención de datos mediante API (se usa un hilo más para no sobrecargar al hilo principal de la app):

        fun getCharacters(recyclerView: RecyclerView, progressBar: ProgressBar, context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                API.instance.getCharacters(ts, apikey, hash)
                    .enqueue(object: Callback<Character> {
                        override fun onResponse(call: Call<Character>, response: Response<Character>) {
                            recyclerView.adapter = CharacterAdapter(response.body()!!.data.results, context)
                            progressBar.visibility = View.GONE
                        }

                        override fun onFailure(call: Call<Character>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }


        fun getComics(characterId: String, recyclerView: RecyclerView, progressBar: ProgressBar, context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                API.instance.getComics(characterId, ts, apikey, hash)
                    .enqueue(object : Callback<Comic> {
                        override fun onResponse(call: Call<Comic>, response: Response<Comic>) {
                            val results = response.body()!!.data.results
                            progressBar.visibility = View.GONE
                            if (results.isNotEmpty()) {
                                recyclerView.adapter = ComicAdapter(results, context)
                            } else {
                                Toast.makeText(context, "There are no comics for this character", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Comic>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }

        fun getEvents(characterId: String, recyclerView: RecyclerView, progressBar: ProgressBar, context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                API.instance.getEvents(characterId, ts, apikey, hash)
                    .enqueue(object : Callback<Event> {
                        override fun onResponse(call: Call<Event>, response: Response<Event>) {
                            val results = response.body()!!.data.results
                            progressBar.visibility = View.GONE
                            if (results.isNotEmpty()) {
                                recyclerView.adapter = EventAdapter(results, context)
                            } else {
                                Toast.makeText(context, "There are no events for this character", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Event>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }

        fun getSeries(characterId: String, recyclerView: RecyclerView, progressBar: ProgressBar, context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                API.instance.getSeries(characterId, ts, apikey, hash)
                    .enqueue(object : Callback<Serie> {
                        override fun onResponse(call: Call<Serie>, response: Response<Serie>) {
                            val results = response.body()!!.data.results
                            progressBar.visibility = View.GONE
                            if (results.isNotEmpty()) {
                                recyclerView.adapter = SerieAdapter(results, context)
                            } else {
                                Toast.makeText(context, "There are no series for this character", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Serie>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }

        fun getStories(characterId: String, recyclerView: RecyclerView, progressBar: ProgressBar, context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                API.instance.getStories(characterId, ts, apikey, hash)
                    .enqueue(object : Callback<Story> {
                        override fun onResponse(call: Call<Story>, response: Response<Story>) {
                            val results = response.body()!!.data.results
                            progressBar.visibility = View.GONE
                            if (results.isNotEmpty()) {
                                recyclerView.adapter = StoryAdapter(results)
                            } else {
                                Toast.makeText(context, "There are no stories for this character", Toast.LENGTH_LONG).show()
                            }
                        }

                        override fun onFailure(call: Call<Story>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }
    }
}