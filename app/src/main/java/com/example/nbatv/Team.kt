package com.example.nbatv

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

data class Team (
    @PrimaryKey val id: Int,
    val teamId: Int,
    val teamName: String?,
    val wins: Int,
    val losses: Int
)