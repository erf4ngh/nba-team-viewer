package com.example.nbatv

import com.example.nbatv.internal.TeamEntity

interface TeamRepository {
    fun getAllTeams(): MutableList<TeamEntity>?
}