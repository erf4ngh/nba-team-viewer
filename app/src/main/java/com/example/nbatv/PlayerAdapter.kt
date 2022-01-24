//package com.example.nbatv
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.layout_player.view.*
//
//class PlayerAdapter(val team: List<Player>?) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
//        return PlayerViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.layout_player, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: PlayerViewHolder, pos: Int) {
//        val curPlayer = player?.get(pos)
//        holder.view.textViewFirstName.text = curPlayer!!.firstName.toString()
//        holder.view.textViewLastName.text = curPlayer.lastName.toString()
//        holder.view.textViewPosition.text = curPlayer.position.toString()
//        holder.view.textViewNumber.text = curPlayer.number.toString()
//    }
//
//    override fun getItemCount(): Int = player!!.size
//
//    class PlayerViewHolder(val view: View) : RecyclerView.ViewHolder(view)
//}