package com.example.nbatv.internal

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.nbatv.Team
import com.example.nbatv.internal.TeamsRepository.Companion.NETWORK_PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException


private const val STARTING_PAGE_INDEX = 1


class TeamsPagingSource(
    private val service: TeamsService //teamsService
) : PagingSource<Int, Team>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Team> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getTeams()
            val teams = response
            val nextKey =
                if (teams.isEmpty()) {
                    null
                } else {
                    pageIndex + (params.loadSize / NETWORK_PAGE_SIZE)
                }
            LoadResult.Page(
                data = teams,
                prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Team>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}