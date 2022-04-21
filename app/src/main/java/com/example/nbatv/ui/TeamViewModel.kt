package com.example.nbatv.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.nbatv.ui.models.Team
import com.example.nbatv.data.repository.TeamsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamViewModel(
    val repository: TeamsRepository
    ) : ViewModel() {
        suspend fun getAllTeams(): Flow<PagingData<Team>> {
            return repository.getTeams().cachedIn(viewModelScope)
        }
    }