package com.carlos.marvelapp.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import de.hdodenhof.circleimageview.CircleImageView

class CharactersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var characterName: TextView
    var characterImage: CircleImageView

    init {
        characterName = itemView.findViewById(R.id.characterName)
        characterImage = itemView.findViewById(R.id.characterImage)
    }
}