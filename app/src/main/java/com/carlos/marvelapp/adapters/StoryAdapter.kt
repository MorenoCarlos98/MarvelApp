package com.carlos.marvelapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultStory

class StoryAdapter(val data: List<ResultStory>): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    //Creación de ViewHolder
    inner class StoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var storyName: TextView

        init {
            storyName = itemView.findViewById(R.id.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_story,
            parent,
            false
        )
        return StoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {

        //Obtención de los datos que nos interesan de cada historia
        val story = data[position]

        //Añadimos el nombre al elemento name del layout item
        holder.storyName.text = story.title
    }

    override fun getItemCount(): Int {

        //Devuelve el número de elementos obtenidos
        return data.size
    }
}