package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository

abstract class MemoryCachingTeamRepository(private val delegate: TeamRepository) : TeamRepository by delegate {
    var teams : List<Team>? = null
    override fun getAllTeams(): List<Team>? {
        if(getAllTeams() != null){
            return getAllTeams()
        }
        return delegate.getAllTeams()
    }
}