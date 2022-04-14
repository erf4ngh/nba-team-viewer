package com.example.nbatv.internal

import com.example.nbatv.Team
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamsService {
    @GET("teams")
    suspend fun getTeams(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<Team>

    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/erf4ngh/nba-team-viewer/"

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