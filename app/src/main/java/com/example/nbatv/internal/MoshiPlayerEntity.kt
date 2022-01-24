package com.example.nbatv.internal

import com.squareup.moshi.Json

data class MoshiPlayerEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "first_name") val firstName: String?,
    @Json(name = "last_name") val lastName: String?,
    @Json(name = "position") val position: String?,
    @Json(name = "number") val number: Int?,
)