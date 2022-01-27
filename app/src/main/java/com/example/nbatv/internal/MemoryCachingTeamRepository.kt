package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository

class MemoryCachingTeamRepository(private val delegate: TeamRepository) : TeamRepository {
    var teams : List<Team>? = null
    override fun getAllTeams(): List<Team>? {
        if(teams != null){
            return teams
        }
        teams = delegate.getAllTeams()
        return teams
    }
}