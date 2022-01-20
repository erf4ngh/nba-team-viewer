package com.example.nbatv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refreshLayout.setOnRefreshListener {
            fetchTeams()
        }
        fetchTeams()
    }

    private fun fetchTeams(){

        refreshLayout.isRefreshing = true

        NbaJSONEndpoint().getTeam().enqueue(object: Callback<List<Team>>{
            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
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
        reyclerViewTeams.layoutManager = LinearLayout(this)
        recyclerViewTeams.adapter = TeamsAdapter(team)
    }
}