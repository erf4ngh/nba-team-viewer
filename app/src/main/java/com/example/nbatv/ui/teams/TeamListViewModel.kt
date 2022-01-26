package com.example.nbatv.ui.teams

import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.HttpUrlConnectionTeamRepository
import kotlin.concurrent.thread

class TeamListViewModel(private val teamRepository: TeamRepository = HttpUrlConnectionTeamRepository()) : ViewModel() {
    private var teams: List<Team>? = null
    fun getAllTeams(): List<Team>? {
        if(teams != null){
            return teams
        }
        thread {
            teams = teamRepository.getAllTeams()
        }.join()
        return teams
    }

    fun getTeamsSortedByName(): List<Team> {
        return getAllTeams()!!.sortedBy { it.teamName }
    }

    fun getTeamsSortedByWins() : List<Team> {
        return getAllTeams()!!.sortedByDescending { it.wins }
    }

    fun getTeamsSortedByLosses() : List<Team> {
        return getAllTeams()!!.sortedByDescending { it.losses }
    }
}