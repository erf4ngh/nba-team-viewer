package com.example.nbatv

import com.example.nbatv.Player

data class Team {
    val id: Int,
            val wins: Int,
                    val losses: Int,
                            val full_name: String,
                                    val players: List<Player>
}