package com.example.nbatv.ui.teams

import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.HttpUrlConnectionTeamRepository
import kotlin.concurrent.thread

class TeamViewModel : ViewModel() {
    private val teamRepository : TeamRepository = HttpUrlConnectionTeamRepository()
    fun getAllTeams() : List<Team>?{
        var teams : List<Team>? = null
        thread(start = true){
            teams = teamRepository.getAllTeams()
        }.join()
        return teams
    }
}