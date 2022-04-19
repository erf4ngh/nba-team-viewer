package com.example.nbatv.internal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.nbatv.R
import com.example.nbatv.ui.models.Team
import kotlinx.android.synthetic.main.layout_team.view.*

class RemoteTeamsAdapter :
    PagingDataAdapter<Team, RecyclerView.ViewHolder>(REPO_COMPARATOR){
    companion object {
        private val REPO_COMPARATOR = object: DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean = oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? TeamsViewHolder)?.bind(team = getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TeamsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_team, parent, false)
        )
    }

    //viewholder
    class TeamsViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        companion object {
            fun getInstance(parent: ViewGroup): TeamsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.teams_fragment, parent, false)
                return TeamsViewHolder(view)
            }
        }

        fun bind(team : Team){
            containerView.textViewName.text = team.teamName.toString()
            containerView.textViewLosses.text = team.losses.toString()
            containerView.textViewWins.text = team.wins.toString()
        }
    }
}