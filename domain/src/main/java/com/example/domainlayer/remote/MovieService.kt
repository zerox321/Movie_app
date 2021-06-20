package com.example.domainlayer.remote

import com.example.datalayer.constants.Constant.popularConstant
import com.example.datalayer.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieService {
    @GET(value = "movie/{type}")
    suspend fun getMovies(
        @Path("type") type: String,
        @Query("page") pageNumber: Int
    ): MovieResponse
}