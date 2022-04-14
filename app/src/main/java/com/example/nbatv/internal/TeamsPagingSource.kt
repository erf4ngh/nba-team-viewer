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
            val response = service.getTeams(pageIndex, params.loadSize)
            LoadResult.Page(
                response, prevKey = if(pageIndex == STARTING_PAGE_INDEX) null else pageIndex - 1,
                nextKey = if (response.isEmpty()) null else pageIndex + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}