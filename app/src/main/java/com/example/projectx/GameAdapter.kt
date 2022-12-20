package com.example.projectx

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectx.databinding.ItemGameBinding
class GameAdapter (var games: ArrayList<Game>,var onClickListener : onClickListener) : RecyclerView.Adapter<GameAdapter.GameViewHolder>()
{

    inner class GameViewHolder(val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root)

    // if the user scrolled little bit and another item was recycled and new item needs to be viewed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        // it will crash if we wouldn't have set last parameter as false in rv
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameBinding.inflate(layoutInflater, parent, false)
        return GameViewHolder(binding)

    }
    // sets the text and other viewed stuff initially
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.apply {
            tvGame.text = games[position].title
            tvScore.text = games[position].score
            tvType.text = games[position].type
            Glide.with(this.ivImage).load(games[position].imageURL).into(ivImage)
        }
        holder.itemView.setOnClickListener (
            object : View.OnClickListener {
            override fun onClick(v: View?) {
                holder.itemView.setBackgroundColor(Color.GRAY)
                onClickListener.onGameClickListener(holder.adapterPosition , v )
            }
            })

    }

    // how many items we have currently in recyclerview,
    override fun getItemCount(): Int {
        return games.size
    }

    fun filterList(filterlist: ArrayList<Game>) {
        // below line is to add our filtered
        // list in our course array list.
        games = filterlist
    }
}