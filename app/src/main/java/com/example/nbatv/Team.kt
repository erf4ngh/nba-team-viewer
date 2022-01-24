package com.example.nbatv

import java.io.Serializable

data class Team (
        val id: Int,
        val teamName: String?,
        val wins: Int?,
        val losses: Int?,
        val players: List<Player>?,
) : Serializable