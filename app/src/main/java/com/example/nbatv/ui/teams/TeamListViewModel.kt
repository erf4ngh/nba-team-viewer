package com.example.nbatv.ui.teams

import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.example.nbatv.execution.ExecutionContext
import kotlin.concurrent.thread

class TeamListViewModel(private val teamRepository: TeamRepository, private val ui : ExecutionContext, private val io : ExecutionContext) : ViewModel() {

    private var teams: List<Team>? = null
    fun getAllTeams(onTeams: (List<Team>?) -> Unit) {
        io.execute {
            teams = teamRepository.getAllTeams()
            ui.execute { onTeams(teams) }
        }
    }

    fun getTeamsSortedByName(onTeams: (List<Team>?) -> Unit) {
        getAllTeams { teams ->
            onTeams(teams?.sortedBy { it.teamName })
        }
    }

    fun getTeamsSortedByWins(onTeams: (List<Team>?) -> Unit) {
        getAllTeams { teams ->
            onTeams(teams?.sortedByDescending { it.wins })
        }
    }

    fun getTeamsSortedByLosses(onTeams: (List<Team>?) -> Unit) {
        getAllTeams { teams ->
            onTeams(teams?.sortedByDescending { it.losses })
        }
    }
}
