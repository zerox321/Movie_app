package com.example.moveApp.ui.home.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.datalayer.model.Movie
import com.example.domainlayer.remote.MovieService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

abstract class MovieDataSource(private val movieService: MovieService) :
    PagingSource<Int, Movie>() {
    abstract val type: String

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> =
        withContext(IO) {
            return@withContext try {
                val pageNumber = params.key ?: 1
                val response = movieService.getMovies(type = type, pageNumber = pageNumber)
                val prevKey = if (pageNumber == 1) null else pageNumber - 1
                LoadResult.Page(
                    data = response.results ?: listOf(),
                    prevKey = prevKey,
                    nextKey = pageNumber.plus(1)
                )
            } catch (t: Throwable) {
                LoadResult.Error(t)
            }
        }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = state.anchorPosition


}