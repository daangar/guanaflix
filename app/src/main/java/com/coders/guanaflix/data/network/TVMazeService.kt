package com.coders.guanaflix.data.network

import com.coders.guanaflix.data.NetworkConstants
import com.coders.guanaflix.data.network.responses.ShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVMazeService {
    @GET(NetworkConstants.Endpoints.SHOWS)
    suspend fun getShows(@Query("page") page: Int = 0): Response<List<ShowResponse>>
}