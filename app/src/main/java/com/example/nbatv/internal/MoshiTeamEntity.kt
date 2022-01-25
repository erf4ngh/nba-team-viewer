package com.example.nbatv.internal

import com.example.nbatv.Player
import com.squareup.moshi.Json

data class MoshiTeamEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "full_name") val fullName: String?,
    @Json(name = "wins") val wins: Int?,
    @Json(name = "losses") val losses: Int?,
    @Json(name = "players") val players: List<MoshiPlayerEntity>,
)
