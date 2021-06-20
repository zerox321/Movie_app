package com.example.moveApp.ui.home.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.datalayer.model.MovieVideo
import com.example.moveApp.databinding.VideoRowItemBinding

class MovieVideoAdapter(private val movieVideoClickListener: MovieVideoClickListener) :
    ListAdapter<MovieVideo, MovieVideoViewHolder>(MovieVideoDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieVideoViewHolder = MovieVideoViewHolder(
        binding = VideoRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        movieVideoClickListener = movieVideoClickListener
    )


    override fun onBindViewHolder(holder: MovieVideoViewHolder, position: Int) =
        holder.bind(item = getItem(position))


}