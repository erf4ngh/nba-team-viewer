package com.example.nbatv.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.*
//import com.example.nbatv.ui.teams.TeamAdapter

class TeamDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private var viewModel: TeamDetailViewModel = TeamDetailViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val playersList : List<Player>? = viewModel.getAllPlayers() // getAllPlayers can be just a function inside getAllTeams which just returns the list of players for that team
        //playersList.let { showPlayers(it) }
    }

    private fun showPlayers(player : List<Player>?){
//        recyclerViewPlayers.layoutManager = LinearLayoutManager(activity)
//        recyclerViewPlayers.adapter = PlayerAdapter(player)
    }
}