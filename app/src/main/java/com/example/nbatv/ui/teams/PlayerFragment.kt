package com.example.nbatv.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.*
import kotlinx.android.synthetic.main.players_fragment.*
//import com.example.nbatv.TeamAdapter
import kotlinx.android.synthetic.main.teams_fragment.*

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerFragment()
    }

    private var viewModel: PlayerViewModel = PlayerViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.players_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshLayout.setOnRefreshListener {
            //viewModel.getAllPlayers()
        }
        //val playersList : List<Player>? = viewModel.getAllPlayers() // getAllPlayers can be just a function inside getAllTeams which just returns the list of players for that team
        //playersList.let { showPlayers(it) }
    }

    private fun showPlayers(player : List<Player>?){
        recyclerViewPlayers.layoutManager = LinearLayoutManager(activity)
        recyclerViewPlayers.adapter = PlayerAdapter(player)
    }
}