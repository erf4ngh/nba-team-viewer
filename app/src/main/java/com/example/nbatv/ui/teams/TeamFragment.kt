package com.example.nbatv.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.Team
import com.example.nbatv.TeamAdapter
//import com.example.nbatv.TeamAdapter
import kotlinx.android.synthetic.main.teams_fragment.*

class TeamFragment : Fragment() {

    companion object {
        fun newInstance() = TeamFragment()
    }

    private var viewModel: TeamViewModel = TeamViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshLayout.setOnRefreshListener {
            viewModel.getAllTeams()
        }
        viewModel.getAllTeams()
        //val textview = view.findViewById<TextView>(R.id.text)
        //textview.text = viewModel.getAllTeams()
    }

    private fun showTeams(team : List<Team>){
        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
        recyclerViewTeams.adapter = TeamAdapter(team)
    }
}