package com.example.nbatv.ui.teams

import com.example.nbatv.Team
import com.example.nbatv.TeamRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class TeamListViewModelTest {

    val teamsTest : List<Team> = listOf(
        Team(1, "Toronto Raptors", 33, 12, emptyList()),
        Team(2,"Utah Jazz", 34,34, emptyList()),
        Team(3, "Atlanta Hawks", 54, 10, emptyList())
    )

    private lateinit var teamRepository : TeamRepository
    private lateinit var subject : TeamListViewModel

    @Before
    fun setup() {
        teamRepository = mock()
        subject = TeamListViewModel(teamRepository)
    }

    @Test
    fun `verify getting all teams`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        assertEquals(teamsTest, subject.getAllTeams())
    }

    @Test
    fun `verify getting teams sorted by name`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByName : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
        )
        assertEquals(teamsTestSortedByName, subject.getTeamsSortedByName())
    }

    @Test
    fun `verify getting teams sorted by wins`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByWins : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
        )
        assertEquals(teamsTestSortedByWins, subject.getTeamsSortedByWins())
    }

    @Test
    fun `verify getting teams sorted by losses`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByLosses : List<Team> = listOf(
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
        )
        assertEquals(teamsTestSortedByLosses, subject.getTeamsSortedByLosses())
    }
}