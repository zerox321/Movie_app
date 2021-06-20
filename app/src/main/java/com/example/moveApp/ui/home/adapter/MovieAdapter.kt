package com.example.moveApp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.datalayer.model.Movie
import com.example.moveApp.databinding.MovieRowItemBinding

class MovieAdapter(private val clickListener: MovieClickListener) :
    PagingDataAdapter<Movie, MovieViewHolder>(MovieDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder = MovieViewHolder(
        binding = MovieRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickListener = clickListener
    )


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(item=getItem(position))


}