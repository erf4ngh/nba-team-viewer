package com.example.nbatv.data.models

import com.example.nbatv.internal.MoshiPlayerEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoshiTeamEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "full_name") val fullName: String?,
    @Json(name = "wins") val wins: Int?,
    @Json(name = "losses") val losses: Int?,
)
