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

        val view = inflater.inflate(R.layout.fragment_game, container , false)
        // Inflate the layout for this fragment
        val gameList = mutableListOf(
            Game("Grand Theft Auto V",
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
                "Action, shooter"),

            Game("Portal 2",
                "https://static.metacritic.com/images/products/games/8/8ebc9aa5758d569f33e543d9fb629545-98.jpg",
            "Valve is working on a full-length sequel to its award-winning, mind-bending puzzle action game for the Xbox 360 and PC.",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fpc%2Fportal-2%3Fftag%3Dredsoshares&title=Portal%202%20Details%20and%20Credits%20for%20PC",
            "https://www.thinkwithportals.com/about.php",
                "95",
                "Action, puzzle"),

            Game("The Witcher 3: Wild Hunt",
                "https://static.metacritic.com/images/products/games/2/425471cad15e750c9d5c3c50e9604e38-98.jpg",
                "With the Empire attacking the Kingdoms of the North and the Wild Hunt," +
                        " a cavalcade of ghastly riders, breathing down your neck, the only way to " +
                        "survive is to fight back. As Geralt of Rivia, a master swordsman and monster " +
                        "hunter, leave none of your enemies standing. Explore a gigantic open world, " +
                        "slay beasts and decide the fates of whole communities with your actions, all " +
                        "in a genuine next generation format. Also known as \"The Witcher III: Wild Hunt\" ",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fplaystation-4%2Fthe-witcher-3-wild-hunt%3Fftag%3Dredsoshares&title=The%20Witcher%203%3A%20Wild%20Hunt%20for%20PlayStation%204%20Reviews",
            "https://www.thewitcher.com/en",
                "89",
                "Action, puzzle"),

            Game("Left 4 Dead 2",
                "https://static.metacritic.com/images/products/games/3/6092c69b62c2093639f9d728c1439425-98.jpg",
                "Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning" +
                        " Left 4 Dead. This co-operative action horror FPS takes you and your friends through the cities, swamps and" +
                        " cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns. Play as one of" +
                        " four new survivors armed with a wide and devastating array of classic and upgraded weapons. In addition to " +
                        "firearms, you'll also get a chance to take out some aggression on infected with a variety of carnage-creating " +
                        "melee weapons, from chainsaws to axes and even the deadly frying pan. You'll be putting these weapons to the" +
                        " test against (or playing as in Versus) three horrific and formidable new Special Infected. You’ll also encounter" +
                        " five new \"uncommon\" common infected, including the terrifying Mudmen. Helping to take L4D's frantic," +
                        " action-packed gameplay to the next level is AI Director 2.0. This improved Director has the ability to" +
                        " procedurally change the weather you’ll fight through and the pathways you'll take, in addition to tailoring" +
                        " the enemy population, effects, and sounds to match your performance. L4D2 promises a satisfying and uniquely" +
                        " challenging experience every time the game is played, custom-fitted to your style of play. [Valve]",
                "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fpc%2Fleft-4-dead-2%3Fftag%3Dredsoshares&title=Left%204%20Dead%202%20for%20PC%20Reviews",
                "https://www.l4d.com/game.html",
                "89",
                "Action, shooter")
        )
        rvGames = view.findViewById(R.id.rvGames)
        rvGames.setHasFixedSize(true)
        rvGames.layoutManager = LinearLayoutManager(view.context)
        val adapter = GameAdapter(gameList)
        rvGames.adapter = adapter

        return view


    }
}