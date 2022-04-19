package com.example.nbatv.di

import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.*
import com.example.nbatv.old.ui.teamdetail.TeamDetailViewModel
import com.example.nbatv.old.ui.teams.TeamListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nbaTeamModule = module {
    val moshi : Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json"
    val client = OkHttpClient()
    single<TeamJsonAdapter> { MoshiTeamJsonAdapter(moshi) }
    single<TeamRepository> { MemoryCachingTeamRepository(OkHttpTeamRepository(get(), url, client)) }
    viewModel { TeamListViewModel(get()) }
    viewModel { TeamDetailViewModel(get()) }
}