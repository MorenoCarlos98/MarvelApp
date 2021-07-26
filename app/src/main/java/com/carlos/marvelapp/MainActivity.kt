package com.carlos.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.carlos.marvelapp.API.retrofitService
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var superheroes = emptyList<Superheroe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_MarvelApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSuperheroes()
    }

    private fun getSuperheroes() {
        val superheroes: Response<List<Superheroe>> = retrofitService.getCharacters()
        if (superheroes.isSuccessful) {
            this.superheroes = superheroes.body() ?: emptyList()
            val text = findViewById<TextView>(R.id.textView)
            text.text = this.superheroes.get(0).name
        } else {
            showError()
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error al hacer la llamada", Toast.LENGTH_SHORT).show()
    }

}