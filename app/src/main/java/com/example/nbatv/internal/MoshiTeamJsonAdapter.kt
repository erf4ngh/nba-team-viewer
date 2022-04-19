package com.example.nbatv.internal

import com.example.nbatv.ui.models.Team
import com.example.nbatv.data.models.MoshiTeamEntity
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MoshiTeamJsonAdapter(private val moshi: Moshi) : TeamJsonAdapter{
    override fun jsonToTeams(json : String): List<Team> {
        val entityListType = Types.newParameterizedType(List::class.java, MoshiTeamEntity::class.java)
        val jsonAdapter: JsonAdapter<List<MoshiTeamEntity>> = moshi.adapter(entityListType)

        return jsonAdapter.fromJson(json!!)!!.map { it.toTeam() }
    }
}