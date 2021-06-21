package com.example.moveApp.ui.home.details

import com.example.datalayer.model.VideoResponse
import com.example.domainlayer.remote.MovieVideosService
import com.example.moveApp.core.BaseRepository
import com.example.moveApp.core.BaseResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

@ViewModelScoped
class MovieDetailsRepo @Inject constructor(private val movieVideosService: MovieVideosService) :
    BaseRepository() {
    val response = MutableStateFlow<BaseResponse<VideoResponse>?>(null)

    suspend fun getVideos(id: String) =
        response.emitAll(flow = buildApi { buildVideosResponse(id = id) })

    private suspend fun buildVideosResponse(id: String): VideoResponse =
        movieVideosService.getVideos(id = id)


}