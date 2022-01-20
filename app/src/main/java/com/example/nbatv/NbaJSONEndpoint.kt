package com.example.nbatv

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.moshi.MoshiConverterFactory

const val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master"

interface NbaJSONEndpoint {

    @GET("input.json")
    // check this
    fun getTeam() : Call<List<Team>>

    companion object {
        operator fun invoke(): NbaJSONEndpoint {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(NbaJSONEndpoint::class.java)
        }
    }
}

/*
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()*/