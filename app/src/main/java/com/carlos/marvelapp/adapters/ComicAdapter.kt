package com.carlos.marvelapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultX
import de.hdodenhof.circleimageview.CircleImageView

class ComicAdapter(val data: List<ResultX>, val context: Context): RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {
    inner class ComicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var comicName: TextView
        var comicImage: CircleImageView

        init {
            comicName = itemView.findViewById(R.id.name)
            comicImage = itemView.findViewById(R.id.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
        return ComicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        var comic = data[position]

        holder.comicName.text = comic.title

        val image = "${comic.thumbnail.path}/standard_amazing.jpg"

        Glide.with(context).load(image).into(holder.comicImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}