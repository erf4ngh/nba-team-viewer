package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnectionTeamRepository(private val teamJsonAdapter: TeamJsonAdapter) : TeamRepository {
    override fun getAllTeams(): List<Team>? {
        var teamsJson: String? = null
        val url =
            URL("https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        try {
            val response: BufferedInputStream = BufferedInputStream(urlConnection.getInputStream())
            teamsJson = response.bufferedReader().readLines().joinToString(separator = "")
        } finally {
            urlConnection.disconnect()
        }
        return teamJsonAdapter.jsonToTeams(teamsJson!!)
    }
}