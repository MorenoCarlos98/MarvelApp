package com.carlos.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import com.carlos.marvelapp.utils.utils

class MoreInfo : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        //Obtenemos el Bundle para poder usar las variables que hemos pasado entre actividades
        val bundle:Bundle? = intent.extras
        val characterId = bundle?.getString("characterId")
        val option = bundle?.getInt("option")

        recyclerView = findViewById(R.id.recyclerViewDescription)
        progressBar = findViewById(R.id.progressBarDescription)
        progressBar.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Dependiendo de la opción escogida obtendremos diferentes datos
        when(option) {
            0 -> {
                utils.getComics(characterId.toString(), recyclerView, progressBar, this)
            }
            1 -> {
                utils.getEvents(characterId.toString(), recyclerView, progressBar, this)
            }
            2 -> {
                utils.getSeries(characterId.toString(), recyclerView, progressBar, this)
            }
            3 -> {
                utils.getStories(characterId.toString(), recyclerView, progressBar, this)
            }
        }
    }
}