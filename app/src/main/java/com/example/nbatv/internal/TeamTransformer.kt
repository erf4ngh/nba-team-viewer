package com.example.nbatv.internal

import com.example.nbatv.Team


fun MoshiTeamEntity.toTeam() : Team {
    return Team(
        id = this.id,
        teamName = this.teamName,
        wins = this.wins,
        losses = this.losses,
    )
}