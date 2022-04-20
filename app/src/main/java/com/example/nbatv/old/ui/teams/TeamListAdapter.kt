package com.example.nbatv.old.ui.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.R
import com.example.nbatv.ui.models.Team
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_team.view.*

class TeamListAdapter(val teams: List<Team>?, val onTeamClicked: (Team) -> Unit) :
    PagingDataAdapter<Team, TeamListAdapter.TeamViewHolder>(COMP) {

    companion object {
        private val COMP = object: DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_team, parent, false), onTeamClicked
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams!!.get(position))
    }

    override fun getItemCount(): Int = teams!!.size

    class TeamViewHolder(override val containerView: View, val onTeamClicked: (Team) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bind(team : Team){
            containerView.textViewName.text = team.teamName.toString()
            containerView.textViewLosses.text = team.losses.toString()
            containerView.textViewWins.text = team.wins.toString()
            containerView.setOnClickListener{
                onTeamClicked(team)
            }
        }
    }
}