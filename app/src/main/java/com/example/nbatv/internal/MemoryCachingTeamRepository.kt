package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository

abstract class MemoryCachingTeamRepository(private val delegate: TeamRepository) : TeamRepository by delegate {
    override fun getAllTeams(): List<Team>? {
        var teams : List<Team>? = delegate.getAllTeams()
        if(teams != null){
            return teams
        }
        return delegate.getAllTeams()
    }
}