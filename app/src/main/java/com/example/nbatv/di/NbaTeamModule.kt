//package com.example.nbatv.di
//
//import com.example.nbatv.TeamRepository
//import com.example.nbatv.TeamRepositoryImpl
//import com.example.nbatv.internal.HttpUrlConnectionTeamRepository
//import com.example.nbatv.ui.teamdetail.TeamDetailViewModel
//import com.example.nbatv.ui.teams.TeamListViewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val nbaTeamModule = module {
////    single<HttpUrlConnectionTeamRepository> {
////        HttpUrlConnectionTeamRepository()
////    }
//    single<TeamRepository> { TeamRepositoryImpl() }
//
//    viewModel { TeamListViewModel(get())
//
////        TeamDetailViewModel(
////
////        )
//    }
//}