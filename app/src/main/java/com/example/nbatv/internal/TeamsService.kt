package com.example.nbatv.internal

import com.example.nbatv.Team
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TeamsService {
    @GET("scoremedia/nba-team-viewer/master/input.json")
    suspend fun getTeams(): Team

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"

        fun create(): TeamsService {
            val client = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TeamsService::class.java)
        }
    }
}