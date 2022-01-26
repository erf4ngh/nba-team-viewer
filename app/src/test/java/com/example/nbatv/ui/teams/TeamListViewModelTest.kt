package com.example.nbatv.ui.teams

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import org.junit.Assert.*

import org.junit.Test

class TeamListViewModelTest {

    val teamsTest : List<Team> = listOf(
        Team(1, "Toronto Raptors", 33, 12, emptyList()),
        Team(2,"Utah Jazz", 34,34, emptyList()),
        Team(3, "Atlanta Hawks", 54, 10, emptyList())
    )
    private val mockRepository = object: TeamRepository{
        override fun getAllTeams(): List<Team>? {
            return teamsTest
        }
    }
    private val viewModel : TeamListViewModel = TeamListViewModel(mockRepository)

    @Test
    fun getAllTeams() {
        assertEquals(teamsTest, viewModel.getAllTeams())
    }

    @Test
    fun getTeamsSortedByName() {
        val teamsTestSortedByName : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
        )
        assertEquals(teamsTestSortedByName, viewModel.getTeamsSortedByName())
    }

    @Test
    fun getTeamsSortedByWins() {
        val teamsTestSortedByWins : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
        )
        assertEquals(teamsTestSortedByWins, viewModel.getTeamsSortedByWins())
    }

    @Test
    fun getTeamsSortedByLosses() {
        val teamsTestSortedByLosses : List<Team> = listOf(
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
        )
        assertEquals(teamsTestSortedByLosses, viewModel.getTeamsSortedByLosses())
    }
}