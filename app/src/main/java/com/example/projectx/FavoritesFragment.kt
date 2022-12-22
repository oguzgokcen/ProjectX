package com.example.projectx

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class FavoritesFragment : Fragment(), onClickListener {
    lateinit var rvFav : RecyclerView
    lateinit var gameAdapter: GameAdapter
    lateinit var favoritedList: ArrayList<Game>
    lateinit var tempfavoritedList: ArrayList<Game>
    lateinit var favouritesText: TextView
    lateinit var sp: SharedPreferences
    lateinit var spct:SharedPreferences
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container , false)
        rvFav = view.findViewById(R.id.rvFav)
        favouritesText = view.findViewById(R.id.favouritesText)
        sp = this.requireActivity().getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
        spct = this.requireActivity().getSharedPreferences("sharedprefct", Context.MODE_PRIVATE)
        val ct =spct.getInt("ct",0)
        favoritedList = ArrayList()
        if (ct>0) { // fav listesine eklenecek varsa
            val gson = Gson()
            val json = sp.getString("favGames", null)
            val type: Type = object : TypeToken<ArrayList<Game>>() {}.type
            tempfavoritedList = ArrayList()
            tempfavoritedList = gson.fromJson(json,type)
            for (games in tempfavoritedList){
                favoritedList.add(games) // ekleme
            }
        }

        favouritesText.text = "Favorites(${favoritedList.count()})"
        rvFav.setHasFixedSize(true)
        rvFav.layoutManager = LinearLayoutManager(view.context)
        gameAdapter = GameAdapter(favoritedList,this)
        rvFav.adapter = gameAdapter
        return view
    }
    override fun onGameClickListener(position: Int,v: View?) { // TAMAMLANMADI
        val actv = v?.context as AppCompatActivity
        val intent = Intent(actv,DetailActivity::class.java)
        intent.putExtra("name",gameAdapter.games[position].title)
        intent.putExtra("imageUrl",gameAdapter.games[position].imageURL)
        intent.putExtra("gameDesc",gameAdapter.games[position].game_desc)
        intent.putExtra("redditLink",gameAdapter.games[position].reddit_link)
        intent.putExtra("webLink",gameAdapter.games[position].web_link)
        intent.putExtra("score",gameAdapter.games[position].score)
        intent.putExtra("type",gameAdapter.games[position].type)
        startActivity(intent)
    }
}