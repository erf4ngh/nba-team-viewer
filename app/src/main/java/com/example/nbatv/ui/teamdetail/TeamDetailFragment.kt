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
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private val viewModel: TeamDetailViewModel by viewModel()
    val args: TeamDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.teamId = args.teamId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTeam {showTeam(it)}
    }

    private fun showTeam(team : Team){
        recyclerViewPlayers.layoutManager = LinearLayoutManager(activity)
        recyclerViewPlayers.adapter = PlayerAdapter(team.players)
        textViewTeamPageName.text = team.teamName
        textViewTeamPageWins.text = team.wins.toString()
        textViewTeamPageLosses.text = team.losses.toString()
    }
}