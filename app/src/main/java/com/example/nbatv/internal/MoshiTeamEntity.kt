package com.example.nbatv.internal

import com.example.nbatv.Player
import com.squareup.moshi.Json

data class MoshiTeamEntity(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "full_name") val full_name: String?,
    @field:Json(name = "wins") val wins: Int?,
    @field:Json(name = "losses") val losses: Int?,
    @field:Json(name = "players") val players: List<Player>,
)
