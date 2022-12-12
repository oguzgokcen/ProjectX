package com.example.projectx

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class FavoritesFragment : Fragment(),onClickListener {
    lateinit var rvFav : RecyclerView
    lateinit var gameAdapter: GameAdapter
    lateinit var favoritedList: ArrayList<Game>
    lateinit var favouritesText: TextView
    
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container , false)
        rvFav = view.findViewById(R.id.rvFav)
        favouritesText = view.findViewById(R.id.favouritesText)
        addGamestoList()
        favouritesText.text = "Favorites(${favoritedList.count()})"
        rvFav.setHasFixedSize(true)
        rvFav.layoutManager = LinearLayoutManager(view.context)
        gameAdapter = GameAdapter(favoritedList,this)
        rvFav.adapter = gameAdapter
        
        return view
    }
    fun addGamestoList(){
        favoritedList = ArrayList()
        favoritedList.add(Game("Grand Theft Auto V",
            "https://s3-alpha-sig.figma.com/img/23a0/2645/15fb5b947775dad15186f70457f39007?Expires=1671408000&Signature=IRXqA7tsEhkNwYg1-bvMD1yHeSfW2s6jRZY~8GQGOl6DXUN5yrNMXf~GlzzK~4AoGAQHWrnc4fvDPJVNw0oEkRGEx~heBXtM7LQmDmfPP1ztOTuDWY4huLgwGdae4FUf5kWYLvgAGGR52-B6KmxobmTkI~sW2~5bbl16asZdjXTxlu71WwhYDHDj7PdSLHbgU-6CMFzOzM0qwCjlAGIT9UZIhT9phl6-UISET3TCYznN8cAOX2npWe0jWeVuRNzWoG003eOVsZdlL8kcgQOe8wAOTUY~NFFtXG55yzUyujVSCtCM-FbFRd5lPoMFDUVr6rfo1isO5D97M11-prklSg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Los Santos: a sprawling sun-soaked metropolis full of self-help gurus," +
                    " starlets and fading celebrities, once the envy of the Western world, " +
                    "now struggling to stay alive in a time of economic uncertainty and cheap reality TV. " +
                    "Amidst the turmoil, three very unique criminals plot their own chances of survival and success: " +
                    "Franklin, a street hustler looking for tangible opportunities and serious money; " +
                    "Michael, a professional ex-con whose retirement is less rosy than he figured it would be; and Trevor, " +
                    "a violent dude driven by the opportunity for a cheap high and his next big score. With options at a premium, " +
                    "the crew risks it all in a myriad of daring and dangerous heists that could set them up for life.",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fpc%2Fgrand-theft-auto-v%3Fftag%3Dredsoshares&title=Grand%20Theft%20Auto%20V%20for%20PC%20Reviews",
            "https://www.rockstargames.com/gta-v",
            "96",
            "Action, shooter"))
        favoritedList.add( Game("Portal 2",
            "https://s3-alpha-sig.figma.com/img/179b/f4d6/5e080b5bd8adfa7aeabe119671e8542b?Expires=1672012800&Signature=ANFJebCTPG6GkU3nHVg~UWu-0ONsGRGaqgIskwWQSO6Op2yGmNayvdP4eisFj1mg2UqGlDdbK8WUYhcWWNcSUN-hQbiDtUXR~Qs0zLcU3OdD06rikpGJ0OWoG~n3K58m1NB~asyJEGFzg~WRojZxpJKiSW~VobCwWkaZz6hB7XFvn-aIxOUQk2ekNo71pLqfi6K3X1Qrqnf6lLAtZupT8V4fKLDkb-ygHGy0JsYBPQBDsTg6laugfhFeAXxCs7V69PZq~Jc-7BnmTHr1q3C2HEK7VMlfhsdY17q~~sttsrnvAuD4e9uEusAWODdk~gFhaBprytOwRaFAujpBu3yrEA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Valve is working on a full-length sequel to its award-winning, mind-bending puzzle action game for the Xbox 360 and PC.",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fpc%2Fportal-2%3Fftag%3Dredsoshares&title=Portal%202%20Details%20and%20Credits%20for%20PC",
            "https://www.thinkwithportals.com/about.php",
            "95",
            "Action, puzzle"))
    }

    override fun onGameClickListener(position: Int,v: View?) { // TAMAMLANMADI
        val actv = v?.context as AppCompatActivity
        val intent = Intent(actv,DetailActivity::class.java)

        startActivity(intent)
    }
}