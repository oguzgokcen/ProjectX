package com.example.projectx

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameFragment : Fragment() {
    lateinit var rvGames : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_game, container , false);
        // Inflate the layout for this fragment
        val gameList = mutableListOf(
            Game("Grand Theft Auto V", false),
            Game("Portal 2", false),
            Game("The Witcher 3: Wild Hunt", false),
            Game("Left 4 Dead 2", false),
        )
        rvGames = view.findViewById(R.id.rvGames);
        rvGames.setHasFixedSize(true);
        rvGames.layoutManager = LinearLayoutManager(view.context);
        val adapter = GameAdapter(gameList)
        rvGames.adapter = adapter

        return view


    }
}