package com.example.nbatv.repo

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://raw.githubusercontent.com/")
    .addConverterFactory(MoshiConverterFactory.create()).build()

interface NbaJSONEndpoint {

    @GET("scoremedia/nba-team-viewer/master/input.json")
    // check this
    fun getJSON() :
}