package com.example.nbatv.ui.teams

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlin.concurrent.thread

class TeamListViewModel(private val teamRepository: TeamRepository) : ViewModel() {
    private val mainHandler = Handler(Looper.getMainLooper())
    private var teams: List<Team>? = null
    fun getAllTeams(onTeams: (List<Team>?) -> Unit) {
        thread {
            teams = teamRepository.getAllTeams()
            mainHandler.post { onTeams(teams) }
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
