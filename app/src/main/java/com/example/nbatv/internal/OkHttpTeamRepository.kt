package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class OkHttpTeamRepository(private val teamJsonAdapter: TeamJsonAdapter, val url : String, val client: OkHttpClient) : TeamRepository {
    override suspend fun getAllTeams(): Flow<Team> {
        var teamsJson: String? = null
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            teamsJson = response.body!!.string()
        }
        val teams : List<Team> = teamJsonAdapter.jsonToTeams(teamsJson!!)
        return teams.asFlow()
    }
}