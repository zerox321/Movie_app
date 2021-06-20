package com.example.moveApp.ui.home.dataSource

import com.example.domainlayer.remote.MovieService
import com.example.moveApp.core.MovieDataSource

class UpComingMovieDataSource(movieService: MovieService) : MovieDataSource(movieService) {
    override val type: String
    get() = "upcoming"
}