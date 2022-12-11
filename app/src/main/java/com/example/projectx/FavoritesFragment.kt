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
import org.w3c.dom.Text
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
            "https://static.metacritic.com/images/products/games/2/bab786f634eee57a1c68be2dddf3d1e5-98.jpg",
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
            "https://static.metacritic.com/images/products/games/8/8ebc9aa5758d569f33e543d9fb629545-98.jpg",
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