package com.example.nbatv.internal

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class MemoryCachingTeamRepository(private val delegate: TeamRepository) : TeamRepository {
    var teams : List<Team>? = null
    override suspend fun getAllTeams(): Flow<Team> = when(teams) {
        null -> delegate.getAllTeams()
        else -> teams!!.asFlow()
    }
}