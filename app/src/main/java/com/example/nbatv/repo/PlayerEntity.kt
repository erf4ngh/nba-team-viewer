package com.example.nbatv

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity

data class PlayerEntity (
    @PrimaryKey val id: Int,
    @field:Json(name = "id") val playerId: Int,
    val playersTeamId: Int,
    @field:Json(name = "first_name") val firstName: String?,
    @field:Json(name = "last_name") val lastName: String?,
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "position") val position: String?
)