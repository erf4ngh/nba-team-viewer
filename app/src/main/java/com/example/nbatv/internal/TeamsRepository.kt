package com.example.nbatv.internal

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.nbatv.Team
import kotlinx.coroutines.flow.Flow

class TeamsRepository(private val service: TeamsService) {
    fun getTeams(): Flow<PagingData<Team>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { TeamsPagingSource(service) }
        ).flow
    }
    companion object {
        const val NETWORK_PAGE_SIZE = 10
    }
}