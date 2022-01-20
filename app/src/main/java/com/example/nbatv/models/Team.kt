package com.example.nbatv.models

import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class Team (
        @PrimaryKey val id: Int,
        @field:Json(name = "id") val teamId: Int,
        @field:Json(name = "full_name") val teamName: String?,
        @field:Json(name = "wins") val wins: String?,
        @field:Json(name = "losses") val losses: String?
)