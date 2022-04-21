package com.example.nbatv.ui.models

import java.io.Serializable

data class Team (
        val id: Int,
        val teamName: String?,
        val wins: Int?,
        val losses: Int?,
) : Serializable