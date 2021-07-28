package com.carlos.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import com.carlos.marvelapp.utils.Utils

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {

        //Dormimos 1 segundo la app antes de quitar la splashscreen
        Thread.sleep(1000)

        //Usamos de nuevo el tema de la app
        setTheme(R.style.Theme_MarvelApp)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Iniciamos los componentes que vamos a usar
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        progressBar.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Llamamos a la obtención de los personajes
        Utils.getCharacters(recyclerView, progressBar, this)
    }
}