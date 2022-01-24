package com.example.nbatv.internal

import com.example.nbatv.Player
import com.example.nbatv.Team


fun MoshiPlayerEntity.toPlayer() : Player {
    return Player(
        id = this.id,
        firstName = this.first_name,
        lastName = this.last_name,
        position = this.position,
        number = this.number,
    )
}