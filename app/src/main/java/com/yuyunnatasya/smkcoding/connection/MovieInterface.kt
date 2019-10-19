package com.yuyunnatasya.smkcoding.connection

import com.yuyunnatasya.smkcoding.model.ResponseMovieModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieInterface {

    @GET("movie/now_playing")
    fun getListMovieNowPlaying(
        @Query("api_key")
        apiKey: String

    ): Observable<ResponseMovieModel>

}