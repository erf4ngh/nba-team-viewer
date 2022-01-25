package com.example.nbatv

import com.example.nbatv.internal.MoshiPlayerEntity
import java.io.Serializable

data class Team (
        val id: Int,
        val teamName: String?,
        val wins: Int?,
        val losses: Int?,
        val players: List<Player>?,
) : Serializable