package com.example.nbatv

interface TeamRepository {
    fun getAllTeams(): List<Team>?
    fun getTeam(id: Int): Team? = getAllTeams()?.find { it.id == id}
}