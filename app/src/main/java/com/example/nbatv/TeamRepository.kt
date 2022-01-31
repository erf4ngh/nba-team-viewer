package com.example.nbatv

import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getAllTeams(): List<Team>?
    fun getTeam(id: Int): Team? = getAllTeams()?.find { it.id == id}
}

//interface TeamRepository {
//    suspend fun getAllTeams() : Flow<List<Team>> //might need suspend not sure yet
//    fun getTeam(id : Int) : Flow<Team> = getAllTeams().find { it.id == id }
//}