package com.example.nbatv

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

data class Player (
    @PrimaryKey val id: Int,
    val playerId: Int,
    val playersTeamId: Int,
    val firstName: String?,
    val lastName: String?,
    val number: Int,
    val position: String?
)