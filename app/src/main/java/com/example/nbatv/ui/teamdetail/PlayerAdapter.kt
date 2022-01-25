package com.example.nbatv.ui.teamdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbatv.Player
import com.example.nbatv.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_player.view.*

class PlayerAdapter(val players: List<Player>?) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_player, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, pos: Int) {
        holder.bind(players!!.get(pos))
    }

    override fun getItemCount(): Int = players!!.size

    class PlayerViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bind(player: Player){
            containerView.textViewFirstName.text = player.firstName
            containerView.textViewLastName.text = player.lastName
            containerView.textViewPosition.text = player.position
            containerView.textViewNumber.text = player.number.toString()
        }
    }
}
