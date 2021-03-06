package com.example.moveApp.di

import androidx.paging.PagingConfig
import com.example.datalayer.constants.Constant.pageSize
import com.example.domainlayer.remote.MovieService
import com.example.domainlayer.remote.MovieVideosService
import com.example.moveApp.ui.home.dataSource.PopularMovieDataSource
import com.example.moveApp.ui.home.dataSource.TopRatedMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object NetworkProviderModule {

    // provide MovieService with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    // provide MovieVideosService with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun provideMovieVideosService(retrofit: Retrofit): MovieVideosService =
        retrofit.create(MovieVideosService::class.java)

    // provide PagingConfig with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun providePagerConfig(): PagingConfig = PagingConfig(pageSize = pageSize)

    // provide PopularMovieDataSource with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun providePopularMovieDataSource(movieService: MovieService) = PopularMovieDataSource(
        movieService = movieService
    )

    // provide TopRatedMovieDataSource with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun provideTopRatedMovieDataSource(movieService: MovieService) = TopRatedMovieDataSource(
        movieService = movieService
    )


}
