package com.example.nbatv.internal

import androidx.recyclerview.widget.DiffUtil
import com.example.nbatv.Team

class TeamsAdapter : PagingDataAdapter<Team, TeamViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder.create(parent)
    }
    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val teamItem = getItem(position)
        if(teamItem != null) {
            holder.bind(teamItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean =
                oldItem.teamName == newItem.teamName
            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean =
                oldItem == newItem
        }
    }
}