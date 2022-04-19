package com.example.nbatv.internal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.nbatv.ui.models.Team
import com.example.nbatv.repository.TeamsRepository
import kotlinx.coroutines.flow.Flow

class RemoteViewModel(
    val repository: TeamsRepository = TeamsRepository()
    ) : ViewModel() {
        fun fetchTeams(): Flow<PagingData<Team>> {
            return repository.letTeamsFlow()
                .map { it.map { it } }
                .cachedIn(viewModelScope)
        }
    }