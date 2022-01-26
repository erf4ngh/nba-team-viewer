package com.example.nbatv

interface TeamRepository {
    fun getAllTeams(): List<Team>?
}

//class TeamRepositoryImpl() : TeamRepository {
//    override fun getAllTeams() = listOf(
//        Team(1, "Toronto Raptors", 33, 12, emptyList()),)
//}