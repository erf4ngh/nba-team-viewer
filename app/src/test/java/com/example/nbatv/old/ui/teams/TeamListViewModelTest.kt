package com.example.nbatv.old.ui.teams

import com.example.nbatv.ui.models.Team
import com.example.nbatv.execution.SingleThreadExecutionContext
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
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
    private var ioContext : SingleThreadExecutionContext = SingleThreadExecutionContext()
    private var uiContext : SingleThreadExecutionContext = SingleThreadExecutionContext()

    @Before
    fun setup() {
        teamRepository = mock()
        subject = TeamListViewModel(teamRepository, uiContext, ioContext)
    }

    @Test
    fun `verify getting all teams`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        subject.getAllTeams { assertEquals(teamsTest, it)}
    }

    @Test
    fun `verify getting teams sorted by name`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByName : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
        )
        //subject.getTeamsSortedByName { assertEquals(teamsTestSortedByName, it) }
        var actual: List<Team>? = null
        subject.getTeamsSortedByName { actual = it }
//        uiContext.join()
        Thread.sleep(1000)
        assertEquals(teamsTestSortedByName, actual!!)
    }

    @Test
    fun `verify getting teams sorted by wins`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByWins : List<Team> = listOf(
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
        )
//        subject.getTeamsSortedByWins { assertEquals(teamsTestSortedByWins, it); fail() }
//        uiContext.join()
        var actual: List<Team>? = null
        subject.getTeamsSortedByWins { actual = it }
//        uiContext.join()
        Thread.sleep(1000)
        assertEquals(teamsTestSortedByWins, actual!!)
    }

    @Test
    fun `verify getting teams sorted by losses`() {
        whenever(teamRepository.getAllTeams()).doReturn(teamsTest)
        val teamsTestSortedByLosses : List<Team> = listOf(
            Team(2,"Utah Jazz", 34,34, emptyList()),
            Team(1, "Toronto Raptors", 33, 12, emptyList()),
            Team(3, "Atlanta Hawks", 54, 10, emptyList()),
        )
        //subject.getTeamsSortedByLosses { assertEquals(teamsTestSortedByLosses, it)}
        var actual: List<Team>? = null
        subject.getTeamsSortedByLosses { actual = it }
//        uiContext.join()
        Thread.sleep(1000)
        assertEquals(teamsTestSortedByLosses, actual!!)
    }
}