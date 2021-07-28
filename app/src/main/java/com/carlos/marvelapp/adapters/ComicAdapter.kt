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
import com.carlos.marvelapp.models.ResultX
import de.hdodenhof.circleimageview.CircleImageView


class ComicAdapter(val data: List<ResultX>, val context: Context): RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    //Creación de ViewHolder
    inner class ComicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var comicName: TextView
        var comicImage: CircleImageView
        lateinit var comicDescription: String

        init {
            comicName = itemView.findViewById(R.id.name)
            comicImage = itemView.findViewById(R.id.image)

            //Listener del item pulsado
            itemView.setOnClickListener{

                //Creación del cuadro de diálogo
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Description")
                    .setMessage(comicDescription)
                    .setCancelable(false)
                    .setPositiveButton("OK", null)
                val alert = builder.create()
                alert.show()
            }
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

        //Obtención de los datos que nos interesan de cada cómic
        val comic = data[position]

        holder.comicDescription = comic.description

        //Añadimos el nombre al elemento name del layout item
        holder.comicName.text = comic.title

        val image = "${comic.thumbnail.path}/standard_amazing.jpg"

        //Obtención de la imagen a través del enlace y la añadimos al elemento image del layout item
        Glide.with(context).load(image).into(holder.comicImage)
    }

    override fun getItemCount(): Int {

        //Devuelve el número de elementos obtenidos
        return data.size
    }
}