package com.example.nbatv.ui.teamdetail


import androidx.lifecycle.ViewModel
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDetailViewModel(private val teamRepository: TeamRepository) : ViewModel() {
    var teamId : Int? = null

    fun getTeam(onTeam: (team: Team) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            //val team = teamRepository.getTeam(teamId!!)
            val team = Team(1, "Team", 35,34, emptyList())
            onTeam(team!!)
        }
    }
}