package com.example.nbatv.internal

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiParseBuilder : ParseBuilder{
    override fun buildMoshi() : Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}