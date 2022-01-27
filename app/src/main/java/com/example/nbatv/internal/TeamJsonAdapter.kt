package com.example.nbatv.internal

import com.example.nbatv.Team

interface TeamJsonAdapter {
    fun jsonToTeams(json : String) : List<Team>?
}