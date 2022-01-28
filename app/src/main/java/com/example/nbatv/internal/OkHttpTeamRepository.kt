package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


//okHTTP + mock webserver

class OkHttpTeamRepository(private val teamJsonAdapter: TeamJsonAdapter, val url : String) : TeamRepository {
    override fun getAllTeams(): List<Team>? {
        var teamsJson: String? = null
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            teamsJson = response.body!!.string()
        }
        return teamJsonAdapter.jsonToTeams(teamsJson!!)
    }
}