package com.example.moveApp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.datalayer.model.Movie
import com.example.moveApp.databinding.MovieRowItemBinding

class MovieAdapter(private val clickListener: MenuClickListener? = null) :
    PagingDataAdapter<Movie, MenuViewHolder>(MenuDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder = MenuViewHolder(
        binding = MovieRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        clickListener = clickListener
    )


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) =
        holder.bind(item=getItem(position))


}