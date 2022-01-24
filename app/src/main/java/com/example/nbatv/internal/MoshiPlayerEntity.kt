package com.example.nbatv.internal

import com.squareup.moshi.Json

data class MoshiPlayerEntity(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "first_name") val first_name: String?,
    @field:Json(name = "last_name") val last_name: String?,
    @field:Json(name = "position") val position: String?,
    @field:Json(name = "number") val number: Int?,
)