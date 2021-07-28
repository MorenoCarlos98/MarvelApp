package com.carlos.marvelapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultXX
import de.hdodenhof.circleimageview.CircleImageView

class SerieAdapter(val data: List<ResultXX>, val context: Context): RecyclerView.Adapter<SerieAdapter.SerieViewHolder>() {
    inner class SerieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var serieName: TextView
        var serieImage: CircleImageView

        init {
            serieName = itemView.findViewById(R.id.name)
            serieImage = itemView.findViewById(R.id.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
        return SerieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SerieViewHolder, position: Int) {
        var serie = data[position]

        holder.serieName.text = serie.title

        val image = "${serie.thumbnail.path}/standard_amazing.jpg"

        Glide.with(context).load(image).into(holder.serieImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}