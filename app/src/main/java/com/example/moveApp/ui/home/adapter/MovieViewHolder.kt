package com.example.moveApp.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.datalayer.model.Movie
import com.example.moveApp.databinding.MovieRowItemBinding

class MovieViewHolder(
    private val binding: MovieRowItemBinding,
    private val clickListener: MovieClickListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie?) {
        binding.item = item
        binding.clickListener = clickListener
    }
}
