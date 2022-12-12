package com.example.projectx

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

import kotlin.collections.ArrayList
class GameFragment() : Fragment()  ,onClickListener {
    lateinit var rvGames : RecyclerView
    lateinit var gameAdapter: GameAdapter
    lateinit var gameList: ArrayList<Game>
    lateinit var searchView: SearchView
    lateinit var constrain : ConstraintLayout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container , false)
        gameList = ArrayList()
        gameList.add(Game("Grand Theft Auto V",
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
        gameList.add( Game("Portal 2",
            "https://s3-alpha-sig.figma.com/img/179b/f4d6/5e080b5bd8adfa7aeabe119671e8542b?Expires=1672012800&Signature=ANFJebCTPG6GkU3nHVg~UWu-0ONsGRGaqgIskwWQSO6Op2yGmNayvdP4eisFj1mg2UqGlDdbK8WUYhcWWNcSUN-hQbiDtUXR~Qs0zLcU3OdD06rikpGJ0OWoG~n3K58m1NB~asyJEGFzg~WRojZxpJKiSW~VobCwWkaZz6hB7XFvn-aIxOUQk2ekNo71pLqfi6K3X1Qrqnf6lLAtZupT8V4fKLDkb-ygHGy0JsYBPQBDsTg6laugfhFeAXxCs7V69PZq~Jc-7BnmTHr1q3C2HEK7VMlfhsdY17q~~sttsrnvAuD4e9uEusAWODdk~gFhaBprytOwRaFAujpBu3yrEA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "Valve is working on a full-length sequel to its award-winning, mind-bending puzzle action game for the Xbox 360 and PC.",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fpc%2Fportal-2%3Fftag%3Dredsoshares&title=Portal%202%20Details%20and%20Credits%20for%20PC",
            "https://www.thinkwithportals.com/about.php",
            "95",
            "Action, puzzle"))
        gameList.add(Game("The Witcher 3: Wild Hunt",
            "https://s3-alpha-sig.figma.com/img/6675/ae9b/e806e348cf10a14e41380d5aeb493344?Expires=1672012800&Signature=dcG0bPnfLkPLRUIPvxwrAqOTE396fHX0pzU8Prr6O7gGdNeKU4TeDGfhQLlqwv6iWtemNqGudoqUlc0MGB-deEkwJfbZU6rUuyUrsD5GjCpeony9GpA27IYzCKqizsBe6hPW6~vWugEI9un48M7wl6~GBUHH3vG7SsVnBNQ-mLmbegLx8TVg-KMo~RuUUdo7ZEJONKDp5~N~RvHTHboLI~SL2jhDmqxsWafMVza8j8uvijxnx90xZ32cELUuKctTBx4XLl5Iu7UlvKbkjQpzbpYJoL2jdfrNl7pcSrfkQSBky05ChP8isrF3q~58jvlSeSsA-ypikvGlgAfeYWbQZA__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
            "With the Empire attacking the Kingdoms of the North and the Wild Hunt," +
                    " a cavalcade of ghastly riders, breathing down your neck, the only way to " +
                    "survive is to fight back. As Geralt of Rivia, a master swordsman and monster " +
                    "hunter, leave none of your enemies standing. Explore a gigantic open world, " +
                    "slay beasts and decide the fates of whole communities with your actions, all " +
                    "in a genuine next generation format. Also known as \"The Witcher III: Wild Hunt\" ",
            "https://www.reddit.com/submit?url=https%3A%2F%2Fwww.metacritic.com%2Fgame%2Fplaystation-4%2Fthe-witcher-3-wild-hunt%3Fftag%3Dredsoshares&title=The%20Witcher%203%3A%20Wild%20Hunt%20for%20PlayStation%204%20Reviews",
            "https://www.thewitcher.com/en",
            "89",
            "Action, puzzle"))
        gameList.add(Game("Left 4 Dead 2",
            "https://s3-alpha-sig.figma.com/img/7fce/692e/4e70d1d4369be1a0a44ebc78b77deaa0?Expires=1672012800&Signature=YQ2ofomAW3Za1oCb2IepRSWX14dfTS2aJiTtoN1u5jL-4F6~~Jy9VFB7RTGVLhjTqNMZbNAWKaxODcLaspLIrVv3~zCPimzTDKP7JvNF4VFN47P1AeM1fxzU2PFjZ-KFYeiCMhPiDdDqwxjMfQYJdR81l6PzaLS1~TLtKWfCTBOnTX0zNlL8IC5RG4ZA2WCQjJOjbpwKdkBfG3eIeE2nfGSuist0C6ZnV0blOSrS~3Vhj9ZhwGktFOa3AwqzAA6NrCRx7vsYo6p3zoNEJaQafLhfbBsYNNSAn4l~g6auA2SPw1ZVHpCakXIFsl37PaDzJPMxxHrNX-cbcZgY~t0dsw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
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
            "Action, shooter") )
        rvGames = view.findViewById(R.id.rvGames)
        searchView = view.findViewById(R.id.idSV)
        rvGames.setHasFixedSize(true)
        rvGames.layoutManager = LinearLayoutManager(view.context)
        gameAdapter = GameAdapter(gameList,this) // alttaki ile birleştirilebilir
        rvGames.adapter = gameAdapter
        val gameTitles: ArrayList<String> = ArrayList()
        for (item in gameList){
            gameTitles.add(item.title.lowercase())

        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{


            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!gameTitles.contains(query!!.lowercase()))
                    Toast.makeText(activity, "No Data Found..", Toast.LENGTH_SHORT).show()
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return false
            }
        })
        return view
    }

    // ON CLİCK METHOT OGUZ
    override fun onGameClickListener(position: Int,v: View?) {
        val actv = v?.context as AppCompatActivity // viewin activitisini döndür
        v.setBackgroundColor(0xE0E0E0)
        val intent = Intent(actv,DetailActivity::class.java) // intent ile o positiona göre activitye data gönder
        intent.putExtra("name",gameList[position].title)
        intent.putExtra("imageUrl",gameList[position].imageURL)
        intent.putExtra("gameDesc",gameList[position].game_desc)
        intent.putExtra("redditLink",gameList[position].reddit_link)
        intent.putExtra("webLink",gameList[position].web_link)
        intent.putExtra("score",gameList[position].score)
        intent.putExtra("type",gameList[position].type)
        startActivity(intent)
    } // on click end
    private fun filter(text: String?){
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<Game> = ArrayList()

        // running a for loop to compare elements.
        for (item in gameList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.lowercase(Locale.ROOT).contains(text!!.lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        gameAdapter.filterList(filteredlist)
        gameAdapter.notifyDataSetChanged()
    }
}