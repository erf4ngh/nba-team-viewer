package com.example.nbatv.internal

import android.util.Log
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnectionTeamRepository : TeamRepository {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    override fun getAllTeams(): List<Team>? {
        var teamsJson: String? = null
        val url =
            URL("https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        try {
            val response: BufferedInputStream = BufferedInputStream(urlConnection.getInputStream())
            teamsJson = response.bufferedReader().readLines().joinToString(separator = "")
            //Log.v("HttpUrlRepository", "$teamsJson")
        } finally {
            urlConnection.disconnect()
        }

        val entityListType = Types.newParameterizedType(List::class.java, MoshiTeamEntity::class.java)
        val jsonAdapter: JsonAdapter<List<MoshiTeamEntity>> = moshi.adapter(entityListType)

        return jsonAdapter.fromJson(teamsJson!!)?.map {
            it.toTeam()
        }
    }
}