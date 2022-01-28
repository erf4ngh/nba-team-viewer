package com.example.nbatv.di

import com.example.nbatv.TeamRepository
import com.example.nbatv.execution.ExecutionContext
import com.example.nbatv.execution.SingleThreadExecutionContext
import com.example.nbatv.execution.UiExecutionContext
import com.example.nbatv.internal.*
import com.example.nbatv.ui.teamdetail.TeamDetailViewModel
import com.example.nbatv.ui.teams.TeamListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val nbaTeamModule = module {
    val moshi : Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json"
    single<ExecutionContext> (named("ui")) { UiExecutionContext() }
    single<ExecutionContext> (named("io")) { SingleThreadExecutionContext() }
    single<TeamJsonAdapter> { MoshiTeamJsonAdapter(moshi) }
    single<TeamRepository> { MemoryCachingTeamRepository(OkHttpTeamRepository(get(), url)) }
    viewModel { TeamListViewModel(get(),get(named("ui")),get(named("io"))) }
    viewModel { TeamDetailViewModel(get()) }
}