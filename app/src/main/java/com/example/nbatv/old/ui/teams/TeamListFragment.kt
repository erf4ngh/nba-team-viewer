package com.example.nbatv.old.ui.teams

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.internal.RemoteViewModel
import com.example.nbatv.ui.models.Team
import kotlinx.android.synthetic.main.teams_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel



class TeamListFragment : Fragment() {

    companion object {
        fun newInstance() = TeamListFragment()
    }

    private val viewModel: RemoteViewModel by viewModel()
    private val adapter = com.example.nbatv.internal.TeamListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            viewModel.getAllTeams().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
            }
        }
    }


//    private fun fetchTeams() {
//        lifecycleScope.launch {
//            remoteViewModel.getAllTeams().distinctUntilChanged().collectLatest {
//                adapter.submitData(it)
//            }
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.main_menu, menu)
////        super.onCreateOptionsMenu(menu, inflater)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        return when(id) {
//            R.id.sortByName -> {
//                viewModel.getTeamsSortedByName {showTeams(it)}
//                true
//            }
//            R.id.sortByWins -> {
//                viewModel.getTeamsSortedByWins {showTeams(it)}
//                true
//            }
//            R.id.sortByLosses -> {
//                viewModel.getTeamsSortedByLosses {showTeams(it)}
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    private fun showTeams(team : List<Team>?){
        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
        recyclerViewTeams.adapter = TeamListAdapter(team, ::navigateToTeamDetail)
    }
    private fun navigateToTeamDetail(team : Team){
        val action = TeamListFragmentDirections.actionTeamsFragmentToTeamDetailFragment(team.id)
        findNavController().navigate(action)
    }
}