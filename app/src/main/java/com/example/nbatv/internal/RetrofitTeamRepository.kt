package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitTeamRepository : TeamRepository {

    override fun getAllTeams(): MutableList<TeamEntity> {
        var teamList : MutableList<TeamEntity> = mutableListOf<TeamEntity>()

        val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        //retrofit interface call, not sure what to here

        val moshi = Moshi.Builder()
            .build()
        val jsonAdapter: JsonAdapter<TeamEntity> = moshi.adapter<TeamEntity>()
        teamList = jsonAdapter.fromJson(jsonFile) //need to still get this
        return teamList
    }
}