package com.example.nbatv.internal

import android.util.Log
import com.example.nbatv.Player


fun MoshiPlayerEntity.toPlayer() : Player {
    return Player(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        position = this.position,
        number = this.number,
    )
}