package com.example.nbatv.ui.teamdetail

import androidx.lifecycle.ViewModel
import com.example.nbatv.Player
import com.example.nbatv.Team

class TeamDetailViewModel : ViewModel() {
    var team : Team? = null
    fun getAllPlayers() : List<Player>?{
        return team?.players
    }
}