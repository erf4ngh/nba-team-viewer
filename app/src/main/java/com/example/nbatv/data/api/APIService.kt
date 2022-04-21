package com.example.nbatv.data.api

import com.example.nbatv.data.models.MoshiTeamEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("teams")
    suspend fun getTeams(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<MoshiTeamEntity>
    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/erf4ngh/nba-team-viewer/"

        fun create(): APIService {
            val client = OkHttpClient.Builder()
                .build()
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(APIService::class.java)
        }
    }
}
