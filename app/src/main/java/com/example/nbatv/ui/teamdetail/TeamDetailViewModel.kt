package com.example.nbatv.ui.teamdetail

import androidx.lifecycle.ViewModel
import com.example.nbatv.Player
import com.example.nbatv.Team

class TeamDetailViewModel : ViewModel() {
    fun getAllPlayers(team : Team) : List<Player>?{
        var players : List<Player>? = null
        players = team.players
        return players
    }
}