package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MoshiTeamRepository : TeamRepository {

    override fun getAllTeams(): MutableList<TeamEntity> {
        var teamList : MutableList<TeamEntity> = mutableListOf<TeamEntity>()

        val moshi = Moshi.Builder()
            .build()

        val jsonAdapter: JsonAdapter<TeamEntity> = moshi.adapter
        teamList = jsonAdapter.fromJson(jsonFile) //need to still get this

        return teamList
    }
}