package com.example.nbatv.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.nbatv.NbaJSONEndpoint
import com.example.nbatv.R
import com.example.nbatv.TeamsAdapter
import com.example.nbatv.models.Team
import kotlinx.android.synthetic.main.teams_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsFragment : Fragment() {

    companion object {
        fun newInstance() = TeamsFragment()
    }

    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TeamsViewModel::class.java)
        // TODO: Use the ViewModel
        refreshLayout.setOnRefreshListener {
            fetchTeams()
        }
        fetchTeams()
    }

    private fun fetchTeams(){

        refreshLayout.isRefreshing = true

        NbaJSONEndpoint().getTeam().enqueue(object: Callback<List<Team>> {
            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                refreshLayout.isRefreshing = false
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                val teams = response.body()
                teams?.let{
                    showTeams(it)
                }
            }
        })
    }

    private fun showTeams(teams: List<Team>){
        reyclerViewTeams.layoutManager = LinearLayout(activity)
        recyclerViewTeams.adapter = TeamsAdapter(team)
    }
}