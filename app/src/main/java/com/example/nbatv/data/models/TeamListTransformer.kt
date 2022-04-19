package com.example.nbatv.data.models

import com.example.nbatv.ui.models.Team

class TeamListTransformer {
    fun toTeamListResponse(json: List<MoshiTeamEntity>?) : List<Team> {
        with(json) {
            return if (this?.isNotEmpty() == true) {
                this.map { toTeam(it) }
            } else {
                emptyList()
            }
        }
    }

    private fun toTeam(json: MoshiTeamEntity): Team {
        with(json) {
            return Team(
                id = this.id,
                teamName = this.fullName,
                wins = this.wins,
                losses = this.losses,
            )
        }
    }
}