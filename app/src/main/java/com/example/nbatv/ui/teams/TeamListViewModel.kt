package com.example.nbatv.ui.teams

import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamListViewModel(private val teamRepository: TeamRepository) : ViewModel() {

    private var teams: List<Team>? = null

    fun getAllTeams(onTeams: (List<Team>?) -> Unit) {

        GlobalScope.launch {
            teams = teamRepository.getAllTeams()
            withContext(Dispatchers.Main) { onTeams(teams) }
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
