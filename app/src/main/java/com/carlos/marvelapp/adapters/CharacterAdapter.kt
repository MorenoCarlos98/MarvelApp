package com.carlos.marvelapp.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.Result
import com.carlos.marvelapp.ui.MoreInfo
import de.hdodenhof.circleimageview.CircleImageView

class CharacterAdapter(val data: List<Result>, val context: Context): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    //Creación de ViewHolder
    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var characterId: String
        var characterName: TextView
        var characterImage: CircleImageView

        init {
            characterName = itemView.findViewById(R.id.name)
            characterImage = itemView.findViewById(R.id.image)

            //Listener del item pulsado
            itemView.setOnClickListener{

                //Creación del cuadro de diálogo
                val builder = AlertDialog.Builder(context)
                builder.setTitle(R.string.pick_option)
                    .setItems(R.array.info_option) { dialog, which ->
                        val descriptionIntent = Intent(context, MoreInfo::class.java).apply {
                            putExtra("option", which)
                            putExtra("characterId", characterId)
                        }
                        context.startActivity(descriptionIntent)
                    }
                val dialog:AlertDialog = builder.create()
                dialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        //Obtención de los datos que nos interesan de cada personaje
        val character = data[position]

        holder.characterId = character.id.toString()

        //Añadimos el nombre al elemento name del layout item
        holder.characterName.text = character.name

        val image = "${character.thumbnail.path}/standard_amazing.jpg"

        //Obtención de la imagen a través del enlace y la añadimos al elemento image del layout item
        Glide.with(context).load(image).into(holder.characterImage)
    }

    override fun getItemCount(): Int {
        //Devuelve el número de elementos obtenidos
        return data.size
    }
}