package com.example.nbatv.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.nbatv.data.TeamsPagingSource
import com.example.nbatv.ui.models.Team
import com.example.nbatv.data.api.APIService
import com.example.nbatv.data.models.TeamListTransformer
import kotlinx.coroutines.flow.Flow

interface TeamsRepository {
    suspend fun getTeams(): Flow<PagingData<Team>>
}

class TeamsRepositoryImpl(
    private val service: APIService,
    private val transformer: TeamListTransformer
    ) : TeamsRepository {

    override suspend fun getTeams(): Flow<PagingData<Team>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TeamsPagingSource(service, transformer) }
        ).flow
    }
}