package com.carlos.marvelapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.Characters
import com.carlos.marvelapp.models.Result
import com.carlos.marvelapp.viewHolders.CharactersViewHolder

class CharacterAdapter(val data: List<Result>, val context: Context): RecyclerView.Adapter<CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_characters,
            parent,
            false
        )
        return CharactersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        var characters = data[position]

        holder.characterName.text = characters.name

        val image = "${characters.thumbnail.path}/standard_amazing.jpg"

        Glide.with(context).load(image).into(holder.characterImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}