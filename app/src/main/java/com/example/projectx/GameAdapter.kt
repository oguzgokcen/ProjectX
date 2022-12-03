package com.example.projectx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectx.databinding.ItemGameBinding


class GameAdapter (
    var games: List<Game>
    ) : RecyclerView.Adapter<GameAdapter.GameViewHolder>()
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
        }

    }
    // how many items we have currently in recyclerview,
    override fun getItemCount(): Int {
        return games.size
    }
}