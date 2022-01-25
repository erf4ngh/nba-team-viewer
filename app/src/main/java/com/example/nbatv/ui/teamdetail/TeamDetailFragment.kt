package com.example.nbatv.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.*
import kotlinx.android.synthetic.main.team_detail_fragment.*

//import com.example.nbatv.ui.teams.TeamAdapter

class TeamDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private var viewModel: TeamDetailViewModel = TeamDetailViewModel()
    val args: TeamDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playersList : List<Player>? = viewModel.getAllPlayers(args.myArg)
        playersList.let { showPlayers(it) }
    }

    private fun showPlayers(player : List<Player>?){
        recyclerViewPlayers.layoutManager = LinearLayoutManager(activity)
        recyclerViewPlayers.adapter = PlayerAdapter(player)
    }
}