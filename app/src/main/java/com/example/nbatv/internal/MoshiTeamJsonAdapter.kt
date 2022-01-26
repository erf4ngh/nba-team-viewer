package com.example.nbatv.internal

import com.example.nbatv.Team
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiTeamJsonAdapter : TeamJsonAdapter{
    override fun jsonToTeams(json : String): List<Team>? {

        //inject moshi instead
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val entityListType = Types.newParameterizedType(List::class.java, MoshiTeamEntity::class.java)
        val jsonAdapter: JsonAdapter<List<MoshiTeamEntity>> = moshi.adapter(entityListType)

        //fix null stuff
        return jsonAdapter.fromJson(json!!)?.map {
            it.toTeam()
        }
    }
}