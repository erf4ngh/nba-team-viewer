package com.example.nbatv.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.nbatv.ui.models.Team
import com.example.nbatv.internal.TeamsPagingSource
import com.example.nbatv.data.api.APIService
import kotlinx.coroutines.flow.Flow

interface TeamsRepository {
    suspend fun getTeams(): Flow<PagingData<TeamResponse>>
}

class TeamsRepositoryImpl(private val service: APIService) {
    companion object {
        const val NETWORK_PAGE_SIZE = 5
        fun getInstance() = TeamsRepository()
    }

    fun letTeamsFlow(pagingConfig: PagingConfig = getDefaultPageConfig()) : Flow<PagingData<Team>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { TeamsPagingSource(service) }
        ).flow
    }
    fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = 5, enablePlaceholders = false)
    }
}