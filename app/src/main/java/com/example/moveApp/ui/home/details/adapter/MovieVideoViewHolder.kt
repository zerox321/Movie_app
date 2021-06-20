package com.example.moveApp.ui.home.details.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.datalayer.model.MovieVideo
import com.example.moveApp.databinding.VideoRowItemBinding

class MovieVideoViewHolder(
    private val binding: VideoRowItemBinding, private val movieVideoClickListener: MovieVideoClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MovieVideo?) {
        binding.item = item
        binding.movieVideoClickListener = movieVideoClickListener
    }
}
