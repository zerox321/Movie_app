package com.example.moveApp.ui.home.details.adapter

import android.view.View
import com.example.datalayer.model.MovieVideo

interface MovieVideoClickListener {
    fun onItemClick(v: View, item: MovieVideo)
}