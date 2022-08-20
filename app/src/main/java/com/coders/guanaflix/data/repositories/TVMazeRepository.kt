package com.coders.guanaflix.data.repositories

import com.coders.guanaflix.data.NetworkConstants
import com.coders.guanaflix.data.network.TVMazeService
import com.coders.guanaflix.domain.model.Show
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TVMazeRepository: Repository {

    private val tvMazeRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    override suspend fun getData(): List<Show> {
        val service = tvMazeRetrofit.create(TVMazeService::class.java)
        val response = service.getShows()
        return if (response.isSuccessful) {
            response.body()?.let { list ->
                list.map { it.convertToShow() }
            } ?: emptyList()
        } else emptyList()
    }
}