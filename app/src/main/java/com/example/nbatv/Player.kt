package com.example.nbatv

import java.io.Serializable

data class Player (
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val position: String?,
    val number: Int?,
) : Serializable