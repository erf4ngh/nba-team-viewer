package com.example.nbatv.internal

import com.example.nbatv.ui.models.Team

interface TeamJsonAdapter {
    fun jsonToTeams(json : String) : List<Team>
}