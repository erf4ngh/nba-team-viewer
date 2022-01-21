package com.example.nbatv.internal

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

//maybe use this to make it cleaner
interface retrofitApiService {
    @GET("/input.json")
    fun getAllTeams() : Call<MutableList<TeamEntity>>

    companion object{
        val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master"
        fun create() : retrofitApiService {

            // retrofit instance
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(retrofitApiService::class.java)
        }
    }
}