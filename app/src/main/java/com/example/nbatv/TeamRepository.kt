package com.example.nbatv

import com.example.nbatv.ui.models.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList

//interface TeamRepository {
//    fun getAllTeams(): List<Team>?
//    fun getTeam(id: Int): Team? = getAllTeams()?.find { it.id == id}
//}

interface TeamRepository {
    suspend fun getAllTeams() : Flow<Team>
    suspend fun getTeam(id: Int) : Team = getAllTeams().toList().find { it.id == id }!!
}