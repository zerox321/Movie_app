package com.example.datalayer.model

    data class VideoResponse(
    val results: List<MovieVideo>? = listOf())


data class MovieVideo(
    val id: String? = "",
    val key: String? = "",
    val name: String? = "",
    val site: String? = "",
    val size: Int? = 0,
    val type: String? = ""
){
    fun getThumbnail():String="https://i.ytimg.com/vi/$key/hqdefault.jpg"



}