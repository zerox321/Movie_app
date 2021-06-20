package com.example.moveApp.ui.home.adapter

import android.view.View
import com.example.datalayer.model.Movie

interface MenuClickListener {
    fun onItemClick(v: View, item: Movie)
}