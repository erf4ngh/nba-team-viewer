package com.example.nbatv

import com.example.nbatv.internal.MoshiTeamEntity

interface TeamRepository {
    fun getAllTeams(): List<Team>?
}