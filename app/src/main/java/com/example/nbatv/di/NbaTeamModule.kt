package com.example.nbatv.di

import com.example.nbatv.data.api.APIService
import com.example.nbatv.data.models.TeamListTransformer
import com.example.nbatv.data.repository.TeamsRepository
import com.example.nbatv.data.repository.TeamsRepositoryImpl
import com.example.nbatv.ui.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val nbaTeamModule = module {
    single { TeamListTransformer()}
    single { APIService.create() }
    factory<TeamsRepository> {TeamsRepositoryImpl(get(),get())}
    viewModel { TeamViewModel(get()) }
}