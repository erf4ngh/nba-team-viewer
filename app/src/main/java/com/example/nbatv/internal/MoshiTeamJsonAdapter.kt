package com.example.nbatv.internal

import com.example.nbatv.Team
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiTeamJsonAdapter(private val builder: ParseBuilder) : TeamJsonAdapter{
    override fun jsonToTeams(json : String): List<Team>? {
        val entityListType = Types.newParameterizedType(List::class.java, MoshiTeamEntity::class.java)
        val jsonAdapter: JsonAdapter<List<MoshiTeamEntity>> = builder.buildMoshi().adapter(entityListType)

        //fix null stuff
        return jsonAdapter.fromJson(json!!)?.map {
            it.toTeam()
        }
    }
}