package com.carlos.marvelapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultXXXX
import de.hdodenhof.circleimageview.CircleImageView

class EventAdapter (val data: List<ResultXXXX>, val context: Context): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var eventName: TextView
        var eventImage: CircleImageView

        init {
            eventName = itemView.findViewById(R.id.name)
            eventImage = itemView.findViewById(R.id.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        var event = data[position]

        holder.eventName.text = event.title

        val image = "${event.thumbnail.path}/standard_amazing.jpg"

        Glide.with(context).load(image).into(holder.eventImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}