package com.example.datalayer.model

import android.os.Parcelable
import com.example.datalayer.constants.Genres.getGenresName
import kotlinx.android.parcel.Parcelize

data class MovieResponse(
    val page: Int? = 0,
    val results: List<Movie>?,
    val total_pages: Int? = 0,
    val total_results: Int? = 0
)

@Parcelize
data class Movie(
    val adult: Boolean? = false,
    val genre_ids: List<Int>? = listOf(),
    private val backdrop_path: String? = "",
    val id: Int? = 0,
    val original_language: String? = "",
    val original_title: String? = "",
    val overview: String? = "",
    val popularity: Double? = 0.0,
    private val poster_path: String? = "",
    val release_date: String? = "",
    val title: String? = "",
    val video: Boolean? = false,
    private val vote_average: Float?,
    val vote_count: Int? = 0
) : Parcelable {
    fun getVote(): Float = (vote_average ?: 0f) / 2
    fun getFormattedContent() =
        "$release_date | $original_language | $vote_average / 10"

    fun getGenresName() = genre_ids?.joinToString { getGenresName(it) }
    fun getPosterImage() = "https://image.tmdb.org/t/p/original$poster_path"
    fun getBackDropImage() = "https://image.tmdb.org/t/p/original$backdrop_path"

}