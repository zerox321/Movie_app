package com.example.domainlayer.remote

import com.example.datalayer.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieVideosService {

    @GET(value = "movie/{id}/videos")
    suspend fun getVideos(
        @Path("id") id: String
    ): VideoResponse
}