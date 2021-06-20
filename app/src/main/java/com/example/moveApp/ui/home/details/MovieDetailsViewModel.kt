package com.example.moveApp.ui.home.details

import androidx.lifecycle.SavedStateHandle
import com.example.datalayer.model.Movie
import com.example.datalayer.model.MovieVideo
import com.example.datalayer.model.VideoResponse
import com.example.moveApp.core.BaseResponse
import com.example.moveApp.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repo: MovieDetailsRepo,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private val movie = savedStateHandle.get<Movie>("Item")

    val response: StateFlow<BaseResponse<VideoResponse>?> = repo.response.asStateFlow()

    private fun fetchVideoList() = launchTask { repo.getVideos(id = movie?.id.toString()) }

    init {
        fetchVideoList()
    }

}