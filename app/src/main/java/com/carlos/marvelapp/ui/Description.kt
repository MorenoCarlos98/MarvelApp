package com.carlos.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R

class Description : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val bundle:Bundle? = intent.extras
        val characterId = bundle?.get("characterId")
        val option = bundle?.get("option")

        recyclerView = findViewById(R.id.recyclerViewDescription)
        progressBar = findViewById(R.id.progressBarDescription)
        progressBar.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)

        //getComics()
    }
}