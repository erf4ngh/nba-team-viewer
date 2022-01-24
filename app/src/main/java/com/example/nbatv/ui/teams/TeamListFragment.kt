package com.example.nbatv.ui.teams

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.Team
import kotlinx.android.synthetic.main.teams_fragment.*

class TeamListFragment : Fragment() {

    companion object {
        fun newInstance() = TeamListFragment()
    }

    private var viewModel: TeamListViewModel = TeamListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teamsList : List<Team>? = viewModel.getAllTeams()
        teamsList.let { showTeams(it) }
    }

    private fun showTeams(team : List<Team>?){
        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
        recyclerViewTeams.adapter = TeamListAdapter(team, ::navigateToTeamDetail)
    }
    private fun navigateToTeamDetail(team : Team){
        val action = TeamListFragmentDirections.actionTeamsFragmentToTeamDetailFragment(team)
        findNavController().navigate(action)
        Log.v("test", team.toString())
    }
}