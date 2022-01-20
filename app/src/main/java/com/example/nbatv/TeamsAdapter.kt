package com.example.nbatv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.models.Team
import kotlinx.android.synthetic.main.layout_team.view.*

*

class TeamsAdapter(val teams: List<Team>) : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : TeamViewHolder{
        return TeamViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_team, parent, false)
        )
    }

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.view.textViewName.text = team.full_name
        holder.view.textViewWins.text = team.wins
        holder.view.textViewLosses.text = team.losses
        holder.view.textViewIsNew.visibility = if(team.isNew = 1) View.VISIBLE else view.INVISIBLE
    }

    class TeamViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}