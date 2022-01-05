package com.adesso.movee.data.remote.datasource

import com.adesso.movee.data.remote.BaseRemoteDataSource
import com.adesso.movee.data.remote.api.MovieService
import com.adesso.movee.data.remote.model.movie.MovieDetailResponseModel
import com.adesso.movee.data.remote.model.movie.NowPlayingMovieResponseModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSource @Inject constructor(
    private val service: MovieService
) : BaseRemoteDataSource() {

    suspend fun fetchNowPlayingMovies(): NowPlayingMovieResponseModel = invoke {
        service.fetchNowPlayingMovies()
    }

    suspend fun fetchMovieDetail(id: Long): MovieDetailResponseModel = invoke {
        service.fetchMovieDetail(id)
    }

    suspend fun fetchMovieDetailFlow(id: Long): Flow<MovieDetailResponseModel> = invokeFlow {
        service.fetchMovieDetail(id)
    }
}
