package com.carlos.marvelapp.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultEvent
import de.hdodenhof.circleimageview.CircleImageView

class EventAdapter (val data: List<ResultEvent>, val context: Context): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    //Creación de ViewHolder
    inner class EventViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var eventName: TextView
        var eventImage: CircleImageView
        var eventDescription: String = ""

        init {
            eventName = itemView.findViewById(R.id.name)
            eventImage = itemView.findViewById(R.id.image)

            itemView.setOnClickListener{

                //Creación del cuadro de diálogo
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Description")
                    .setMessage(eventDescription)
                    .setCancelable(false)
                    .setPositiveButton("OK", null)
                val alert = builder.create()
                alert.show()
            }
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

        //Obtención de los datos que nos interesan de cada evento
        val event = data[position]


        val desc = event.description
        if (desc != null) holder.eventDescription = desc

        //Añadimos el nombre al elemento name del layout item
        holder.eventName.text = event.title

        val image = "${event.thumbnail.path}/standard_amazing.jpg"

        //Obtención de la imagen a través del enlace y la añadimos al elemento image del layout item
        Glide.with(context).load(image).into(holder.eventImage)
    }

    override fun getItemCount(): Int {

        //Devuelve el número de elementos obtenidos
        return data.size
    }
}