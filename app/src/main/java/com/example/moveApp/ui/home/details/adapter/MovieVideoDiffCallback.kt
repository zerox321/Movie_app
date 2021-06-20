package com.example.moveApp.ui.home.details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.datalayer.model.Movie
import com.example.datalayer.model.MovieVideo

object MovieVideoDiffCallback : DiffUtil.ItemCallback<MovieVideo>() {
    override fun areItemsTheSame(oldItem: MovieVideo, newItem: MovieVideo): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieVideo, newItem: MovieVideo): Boolean =
        oldItem == newItem
}

