package com.example.nbatv.internal

import com.squareup.moshi.Moshi

interface ParseBuilder {
    fun buildMoshi() : Moshi
}