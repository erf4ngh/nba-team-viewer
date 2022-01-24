package com.example.nbatv.internal

import com.example.nbatv.Team


fun MoshiTeamEntity.toTeam() : Team {
    return Team(
        id = this.id,
        teamName = this.fullName,
        wins = this.wins,
        losses = this.losses,
        players = this.players,
    )
}