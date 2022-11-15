package com.example.kotlin_navigation_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideosAdapter(private val videosList: ArrayList<Video>) : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {


    class VideosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val titleView: TextView = itemView.findViewById(R.id.videoTitle)
        val genreView: TextView = itemView.findViewById(R.id.videoGenre)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.videos_recycler_view_card, parent, false)
        return VideosViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        val currentItem = videosList[position]
        holder.titleView.text = currentItem.name
        holder.genreView.text = currentItem.genre
    }

    override fun getItemCount(): Int {
        return videosList.size
    }
}