package com.example.nbatv.di

import com.example.nbatv.TeamRepository
import com.example.nbatv.data.api.APIService
import com.example.nbatv.data.models.TeamListTransformer
import com.example.nbatv.data.repository.TeamsRepository
import com.example.nbatv.data.repository.TeamsRepositoryImpl
import com.example.nbatv.internal.*
import com.example.nbatv.old.ui.teamdetail.TeamDetailViewModel
import com.example.nbatv.old.ui.teams.TeamListViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val nbaTeamModule = module {
    val moshi : Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val url = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/input.json"
    val client = OkHttpClient()
    //single<TeamJsonAdapter> { MoshiTeamJsonAdapter(moshi) }
    //single<TeamRepository> { MemoryCachingTeamRepository(OkHttpTeamRepository(get(), url, client)) }
    single { TeamListTransformer()}
    single { APIService.create() }
    factory<TeamsRepository> {TeamsRepositoryImpl(get(),get())}
    //viewModel { TeamListViewModel(get()) }
    viewModel { RemoteViewModel(get()) }
    //viewModel { TeamDetailViewModel(get()) }
}