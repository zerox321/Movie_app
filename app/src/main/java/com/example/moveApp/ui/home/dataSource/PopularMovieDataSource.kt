package com.example.moveApp.ui.home.dataSource

import com.example.domainlayer.remote.MovieService

class PopularMovieDataSource(movieService: MovieService) : MovieDataSource(movieService) {
    override val type: String
    get() = "popular"
}