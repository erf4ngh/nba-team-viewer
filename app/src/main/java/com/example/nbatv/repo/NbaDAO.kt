package com.example.nbatv.repo

interface NbaDAO {
    suspend fun getPlayer() : Player
    suspend fun getTeam() : Team
}