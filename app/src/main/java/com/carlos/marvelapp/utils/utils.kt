package com.carlos.marvelapp.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.adapters.CharacterAdapter
import com.carlos.marvelapp.adapters.ComicAdapter
import com.carlos.marvelapp.api.API
import com.carlos.marvelapp.models.Character
import com.carlos.marvelapp.models.Comic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class utils {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com"
        const val ts = "1"
        const val apikey:String = "dadded75ae894f33f3fd530f104ce724"
        const val hash:String = "2618ce007444e5a5699ebb24b4c4f95b"

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
                            recyclerView.adapter = ComicAdapter(response.body()!!.data.results, context)
                            progressBar.visibility = View.GONE
                        }

                        override fun onFailure(call: Call<Comic>, t: Throwable) {
                            progressBar.visibility = View.GONE
                        }
                    })
            }
        }
    }
}