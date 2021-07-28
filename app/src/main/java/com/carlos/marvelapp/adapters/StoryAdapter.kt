package com.carlos.marvelapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlos.marvelapp.R
import com.carlos.marvelapp.models.ResultXXX

class StoryAdapter (val data: List<ResultXXX>, val context: Context): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {
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
        var story = data[position]

        holder.storyName.text = story.title
    }

    override fun getItemCount(): Int {
        return data.size
    }
}