package com.example.nbatv.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.*
import com.example.nbatv.ui.teams.TeamListViewModel
import kotlinx.android.synthetic.main.team_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private val viewModel: TeamDetailViewModel by viewModel()
    val args: TeamDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTeam(args.teamId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playersList : List<Player>? = viewModel.getAllPlayers()
        playersList.let { showPlayers(it) }
    }

    private fun showPlayers(player : List<Player>?){
        recyclerViewPlayers.layoutManager = LinearLayoutManager(activity)
        recyclerViewPlayers.adapter = PlayerAdapter(player)
    }
}