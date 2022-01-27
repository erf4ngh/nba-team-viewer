package com.example.nbatv.ui.teamdetail

import androidx.lifecycle.ViewModel
import com.example.nbatv.Player
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository

class TeamDetailViewModel(private val teamRepository: TeamRepository) : ViewModel() {
    var team : Team? = null

    fun getTeam(id: Int): Team? = teamRepository.getAllTeams()?.find { it.id == id}

    fun getAllPlayers() : List<Player>?{
        return team?.players
    }

    fun getTeamName() : String? {
        return team?.teamName
    }
    fun getTeamWins() : String? {
        return team?.wins.toString()
    }
    fun getTeamLosses() : String? {
        return team?.losses.toString()
    }
}