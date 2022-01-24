package com.example.nbatv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.ui.teams.TeamViewModel
import kotlinx.android.synthetic.main.layout_team.view.*

class TeamAdapter(val team: List<Team>?) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_team, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val curTeam = team?.get(position)
        holder.view.textViewName.text = curTeam!!.teamName
        holder.view.textViewLosses.text = curTeam.losses.toString()
        holder.view.textViewWins.text = curTeam.wins.toString()
    }

    override fun getItemCount(): Int = team!!.size

    class TeamViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}