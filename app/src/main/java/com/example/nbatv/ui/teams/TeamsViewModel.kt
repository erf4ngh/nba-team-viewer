package com.example.nbatv.ui.teams

import androidx.lifecycle.ViewModel
import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.HttpUrlConnectionTeamRepository
import kotlin.concurrent.thread

class TeamsViewModel : ViewModel() {
    private val teamRepository : TeamRepository = HttpUrlConnectionTeamRepository()
    fun getAllTeams() : String?{
        var teams : String? = null
        thread(start = true){
            teams = teamRepository.getAllTeams()
        }.join()
        return teams
    }
}