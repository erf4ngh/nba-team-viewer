package com.example.nbatv.ui.teams

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.Team
import kotlinx.android.synthetic.main.teams_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class TeamListFragment : Fragment() {

    companion object {
        fun newInstance() = TeamListFragment()
    }

    private val viewModel: TeamListViewModel by viewModel()
    //private val viewModel: TeamListViewModel = TeamListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when(id) {
            R.id.sortByName -> {
                showTeams(viewModel.getTeamsSortedByName())
                true
            }
            R.id.sortByWins -> {
                showTeams(viewModel.getTeamsSortedByWins())
                true
            }
            R.id.sortByLosses -> {
                showTeams(viewModel.getTeamsSortedByLosses())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showTeams(team : List<Team>?){
        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
        recyclerViewTeams.adapter = TeamListAdapter(team, ::navigateToTeamDetail)
    }
    private fun navigateToTeamDetail(team : Team){
        val action = TeamListFragmentDirections.actionTeamsFragmentToTeamDetailFragment(team)
        findNavController().navigate(action)
    }
}