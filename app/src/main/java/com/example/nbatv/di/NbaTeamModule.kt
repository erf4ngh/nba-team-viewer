package com.example.nbatv.di

import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.*
import com.example.nbatv.ui.teams.TeamListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nbaTeamModule = module {
    single<ParseBuilder> {MoshiParseBuilder()}
    single<TeamJsonAdapter> { MoshiTeamJsonAdapter(get()) }
    single<TeamRepository> { HttpUrlConnectionTeamRepository(get()) }
    viewModel { TeamListViewModel(get()) }
}