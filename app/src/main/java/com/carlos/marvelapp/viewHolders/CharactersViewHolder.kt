package com.carlos.marvelapp.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import de.hdodenhof.circleimageview.CircleImageView

class CharactersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val characterName: TextView = itemView.findViewById(R.id.characterName)
    val characterImage: CircleImageView = itemView.findViewById(R.id.characterImage)
}