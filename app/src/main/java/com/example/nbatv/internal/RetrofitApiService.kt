package com.example.nbatv.internal

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//maybe use this to make it cleaner
interface RetrofitApiService {
    @GET("input.json")
    fun getAllTeams() : Call<MoshiTeamEntity>

    // should this be here or in moshiTeamRepo
    companion object{
        val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/"
        fun create() : RetrofitApiService {

            // retrofit instance
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(RetrofitApiService::class.java)
        }
    }
}