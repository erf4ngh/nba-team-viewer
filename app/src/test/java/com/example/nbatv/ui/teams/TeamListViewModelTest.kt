package com.example.nbatv.ui.teams

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import org.junit.Assert.*

import org.junit.Test

class TeamListViewModelTest {

    @Test
    fun getAllTeams() {
        val teamsTest : List<Team> = listOf(
            Team(1, "Toronto Raptors", 33, 45, emptyList()),
        )
        val mockRepository = object: TeamRepository{
            override fun getAllTeams(): List<Team>? {
                return teamsTest
            }
        }
        val viewModel : TeamListViewModel = TeamListViewModel(mockRepository)
        assertEquals(teamsTest, viewModel.getAllTeams())
    }

    @Test
    fun getTeamsSortedByName() {

    }

    @Test
    fun getTeamsSortedByWins() {

    }

    @Test
    fun getTeamsSortedByLosses() {

    }
}