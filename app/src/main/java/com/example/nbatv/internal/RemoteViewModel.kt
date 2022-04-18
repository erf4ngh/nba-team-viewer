package com.example.nbatv.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.nbatv.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RemoteViewModel(
    val repository: TeamsRepository = TeamsRepository()
    ) : ViewModel() {
        fun fetchTeams(): Flow<PagingData<Team>> {
            return repository.letTeamsFlow()
                .map { it.map { it } }
                .cachedIn(viewModelScope)
        }
    }