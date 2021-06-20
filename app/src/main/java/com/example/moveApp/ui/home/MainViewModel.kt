package com.example.moveApp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moveApp.ui.home.dataSource.PopularMovieDataSource
import com.example.moveApp.ui.home.dataSource.TopRatedMovieDataSource
import com.example.moveApp.ui.home.dataSource.UpComingMovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    pagerConfig: PagingConfig,
    popularMovieDataSource: PopularMovieDataSource,
    topRatedMovieDataSource: TopRatedMovieDataSource,
    upComingMovieDataSource: UpComingMovieDataSource
) : ViewModel() {
    val popularFlow = Pager(pagerConfig) { popularMovieDataSource }.flow.cachedIn(viewModelScope)
    val topRatedFlow = Pager(pagerConfig) { topRatedMovieDataSource }.flow.cachedIn(viewModelScope)
    val upComingFlow = Pager(pagerConfig) { upComingMovieDataSource }.flow.cachedIn(viewModelScope)

    private val _popularLoading = MutableLiveData<Boolean>()
    val popularLoading: LiveData<Boolean> get() = _popularLoading
    fun setPopularLoading(isLoading: Boolean) {
        _popularLoading.value = isLoading
    }

    private val _topRatedLoading = MutableLiveData<Boolean>()
    val topRatedLoading: LiveData<Boolean> get() = _topRatedLoading
    fun setTopRatedLoading(isLoading: Boolean) {
        _topRatedLoading.value = isLoading
    }
    private val _upComingLoading = MutableLiveData<Boolean>()
    val upComingLoading: LiveData<Boolean> get() = _upComingLoading
    fun setUpComingLoadingLoading(isLoading: Boolean) {
        _upComingLoading.value = isLoading
    }
}