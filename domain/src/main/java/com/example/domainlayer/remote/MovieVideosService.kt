package com.example.domainlayer.remote

import com.example.datalayer.model.MenuItem
import com.example.datalayer.model.MovieVideo
import com.example.datalayer.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieVideosService {

    @GET(value = "movie/{id}/videos")
    suspend fun getVideos(
        @Path("id") id: String
    ): VideoResponse
}