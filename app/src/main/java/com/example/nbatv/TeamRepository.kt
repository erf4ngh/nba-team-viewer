package com.example.nbatv

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList

//interface TeamRepository {
//    fun getAllTeams(): List<Team>?
//    fun getTeam(id: Int): Team? = getAllTeams()?.find { it.id == id}
//}

interface TeamRepository {
    suspend fun getAllTeams() : Flow<Team>
    suspend fun getTeam(id: Int) : Team = getAllTeams().toList().find { it.id == id }!!
}