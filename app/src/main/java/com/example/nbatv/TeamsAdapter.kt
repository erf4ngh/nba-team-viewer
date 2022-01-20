package com.example.nbatv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.models.Team
import kotlinx.android.synthetic.main.layout_team.view.*
import kotlinx.android.synthetic.main.teams_fragment.view.*

class TeamsAdapter(val team: List<Team>) : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TeamViewHolder{
        return TeamViewHolder(
            LayoutInflater.from(parent.context)
        //        .inflate(R.layout.teams_fragment, parent, false)
              .inflate(R.layout.layout_team, parent, false)
        )
    }

    override fun getItemCount() = team.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = team[position]
        holder.view.textViewName.text = team.teamName
        holder.view.textViewWins.text = team.wins
        holder.view.textViewLosses.text = team.losses
    }

    class TeamViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}