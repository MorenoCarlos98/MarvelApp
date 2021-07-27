package com.carlos.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.carlos.marvelapp.API.retrofitService
import com.carlos.marvelapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //var AllSuperheroes = emptyList<Superheroe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_MarvelApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getSuperheroes()
    }

    //private fun getSuperheroes() {
    //    CoroutineScope(Dispatchers.IO).launch {
            //val superheroes: Response<List<Superheroe>> = retrofitService.getCharacters()
            //if (superheroes.isSuccessful) {
            //    AllSuperheroes = superheroes.body() ?: emptyList()
            //    val text = findViewById<TextView>(R.id.textView)
            //    text.text = AllSuperheroes.get(0).name
            //} else {
            //    showError()
            //}
    //    }
    //}

    private fun showError() {
        runOnUiThread {
            Toast.makeText(this, "Error al hacer la llamada", Toast.LENGTH_SHORT).show()
        }
    }

}