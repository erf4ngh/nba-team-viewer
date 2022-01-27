package com.example.nbatv.di

import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.*
import com.example.nbatv.ui.teamdetail.TeamDetailViewModel
import com.example.nbatv.ui.teams.TeamListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nbaTeamModule = module {
    val moshi : Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    single<TeamJsonAdapter> { MoshiTeamJsonAdapter(moshi) }
    single<TeamRepository> { HttpUrlConnectionTeamRepository(get()) }
    viewModel { TeamListViewModel(get()) }
    viewModel { TeamDetailViewModel(get()) }
}