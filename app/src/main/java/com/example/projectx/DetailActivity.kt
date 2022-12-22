package com.example.projectx

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.projectx.Models.GameModel
import com.example.projectx.Models.GenresModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Suppress("NAME_SHADOWING")
class DetailActivity : AppCompatActivity() {
    lateinit var imageDetail: ImageView //Views
    lateinit var gameDescr :TextView
    lateinit var gameTitle : TextView
    lateinit var redditLinkText : TextView
    lateinit var webLinkText : TextView
    lateinit var gameButton : TextView
    lateinit var favButton :TextView
    lateinit var favFragment: FavoritesFragment
    lateinit var sp: SharedPreferences
    lateinit var spct: SharedPreferences
    lateinit var list:ArrayList<GameModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindViews()
        val bundle = Bundle()
        val game : GameModel = intent.getSerializableExtra("game") as GameModel
        initViews(game.name,game.background_image,game.description,game.reddit_url,game.website) // intent'den verileri alma

        sp = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) //sp oluşturulması
        spct =getSharedPreferences("sharedprefct",Context.MODE_PRIVATE)
        favButton.setOnClickListener {
            val editor = sp.edit() // editor oluşturulması
            val cteditor = spct.edit()
            var ct:Int = spct.getInt("ct",0) // counterı al
            val gson = Gson()
            list = ArrayList()
            if(ct!=0) { // eğer favori listesi boş değilse o anki listeyi al
                val currjson = sp.getString("favGames", null)
                val type: Type = object : TypeToken<ArrayList<GameModel>>() {}.type
                list = gson.fromJson(currjson, type)
            }
            if(!list.contains(game)){ // favoride yoksa ekle
                list.add(game)
                val json = gson.toJson(list)
                editor.putString("favGames",json)
                ct+=1 // sayaçı arttır
                cteditor.putInt("ct",ct)
                Toast.makeText(this, "Oyun eklendi ", Toast.LENGTH_SHORT).show()
            }
            cteditor.apply()
            editor.apply()
            /*cteditor.clear().commit() // şimdilik fav listi temizlemek için bir oyuna gir fav ekleye bas
            editor.clear().commit()*/
        }
        gameButton.setOnClickListener { // geri dönüş butonu
            finish()
            favFragment.arguments = bundle
        }
    }
    fun bindViews(){ //bind
        imageDetail = findViewById(R.id.imageDetail)
        gameDescr =findViewById(R.id.gameDesc)
        gameTitle = findViewById(R.id.gameTitle)
        redditLinkText = findViewById(R.id.redditLink)
        webLinkText = findViewById(R.id.webLink)
        gameButton =findViewById(R.id.gameButton)
        favButton = findViewById(R.id.favButton)
        favFragment = FavoritesFragment()
    }
    fun initViews(name:String?,imageUrl:String?,gameDesc: String?,redditLink: String?,webLink:String?){
        gameTitle.text =name // oyun adı
        Glide.with(imageDetail).load(imageUrl).into(imageDetail) // oyun resmi url'den
        gameDescr.text = gameDesc // oyun açıklaması
        redditLinkText.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(redditLink))
            startActivity(intent)
        }
        webLinkText.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webLink))
            startActivity(intent)
        }
    }
}