package com.example.moveApp.ui.home.dataSource

import com.example.domainlayer.remote.MovieService
import com.example.moveApp.core.MovieDataSource

class TopRatedMovieDataSource(movieService: MovieService) : MovieDataSource(movieService) {
    override val type: String
        get() = "top_rated"
}