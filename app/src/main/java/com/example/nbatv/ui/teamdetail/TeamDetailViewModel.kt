package com.example.nbatv.ui.teamdetail

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.example.nbatv.Player
import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import kotlin.concurrent.thread

class TeamDetailViewModel(private val teamRepository: TeamRepository) : ViewModel() {
    var teamId : Int? = null

    private val mainHandler = Handler(Looper.getMainLooper())
    fun getTeam(onTeam: (team: Team) -> Unit) {
        thread {
            val team = teamRepository.getTeam(teamId!!) //teamId? let {} fix
            mainHandler.post { onTeam(team!!) }
        }
    }

//    fun getTeam(id: Int): Team? = Team(1,"Hello",34,34, listOf(Player(2,"Giannis","A","C",34)))
//    fun getAllPlayers() : List<Player>?{
//        return team?.players
//    }
//
//    fun getTeamName() : String? {
//        return team?.teamName
//    }
//    fun getTeamWins() : String? {
//        return team?.wins.toString()
//    }
//    fun getTeamLosses() : String? {
//        return team?.losses.toString()
//    }
}