package com.example.nbatv.ui.teamdetail


import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamDetailViewModel(private val teamRepository: TeamRepository) : ViewModel() {
    var teamId : Int? = null

    fun getTeam(onTeam: (team: Team) -> Unit) {
        GlobalScope.launch {
            val team = teamRepository.getTeam(teamId!!)
            withContext(Dispatchers.Main) { onTeam(team) }
        }
    }
}