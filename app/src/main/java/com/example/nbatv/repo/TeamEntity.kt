package com.example.nbatv.repo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity

data class TeamEntity (
    @PrimaryKey val id: Int,
    @field:Json(name = "id") val teamId: Int,
    @field:Json(name = "full_name") val teamName: String?,
    @field:Json(name = "wins") val wins: Int,
    @field:Json(name = "losses") val losses: Int
)