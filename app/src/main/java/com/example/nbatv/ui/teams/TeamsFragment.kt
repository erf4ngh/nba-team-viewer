package com.example.nbatv.ui.teams

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbatv.R
import com.example.nbatv.Team
//import com.example.nbatv.TeamAdapter
import com.example.nbatv.TeamRepository
import com.example.nbatv.internal.HttpUrlConnectionTeamRepository
import kotlinx.android.synthetic.main.teams_fragment.*
import org.w3c.dom.Text
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class TeamsFragment : Fragment() {

    companion object {
        fun newInstance() = TeamsFragment()
    }

    private var viewModel: TeamsViewModel = TeamsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textview = view.findViewById<TextView>(R.id.text)
//        val nameTextView = view.findViewById<TextView>(R.id.textViewName)
//        val winsTextView = view.findViewById<TextView>(R.id.textViewWins)
//        val lossesTextView = view.findViewById<TextView>(R.id.textViewLosses)
        textview.text = viewModel.getAllTeams()
    }

//    private fun showTeams(team : List<Team>){
//        recyclerViewTeams.layoutManager = LinearLayoutManager(activity)
//        recyclerViewTeams.adapter = TeamAdapter(team)
//    }
}