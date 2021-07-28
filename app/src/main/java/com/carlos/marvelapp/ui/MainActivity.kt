package com.carlos.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import com.carlos.marvelapp.adapters.CharacterAdapter
import com.carlos.marvelapp.api.API
import com.carlos.marvelapp.api.APIService
import com.carlos.marvelapp.models.Characters
import com.carlos.marvelapp.utils.constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    //var AllSuperheroes = emptyList<Superheroe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_MarvelApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getCharacters()
    }

    private fun getCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            API.instance.getCharacters(constants.ts, constants.apikey, constants.hash)
                .enqueue(object: Callback<Characters> {
                    override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                        recyclerView.adapter = CharacterAdapter(response.body()!!.data.results, this@MainActivity)
                    }

                    override fun onFailure(call: Call<Characters>, t: Throwable) {
                        showError()
                    }
                })
        }
    }

    private fun showError() {
        runOnUiThread {
            Toast.makeText(this, "Error al hacer la llamada", Toast.LENGTH_SHORT).show()
        }
    }

}