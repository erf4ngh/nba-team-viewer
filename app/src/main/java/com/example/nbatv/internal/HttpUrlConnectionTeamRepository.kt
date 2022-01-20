package com.example.nbatv.internal

import android.util.Log
import com.example.nbatv.TeamRepository
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class HttpUrlConnectionTeamRepository : TeamRepository {
    override fun getAllTeams(): String? {
        var teams: String? = null
        val url =
            URL("https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        try {
            val response: BufferedInputStream = BufferedInputStream(urlConnection.getInputStream())
            teams = response.bufferedReader().readLines().joinToString()
            Log.v("HttpUrlRepository", "$teams")
        } finally {
            urlConnection.disconnect()
        }
        return teams
    }
}