package com.example.projectx

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import java.net.URL

class DetailActivity : AppCompatActivity() {
    lateinit var imageDetail: ImageView //Viewlar
    lateinit var gameDescr :TextView
    lateinit var gameTitle : TextView
    lateinit var redditLinkText : TextView
    lateinit var webLinkText : TextView
    lateinit var gameButton : TextView
    lateinit var favButton :TextView
    lateinit var favFragment: FavoritesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindViews()
        val name = intent.getStringExtra("name")
        val imageUrl = intent.getStringExtra("imageUrl")
        val gameDesc = intent.getStringExtra("gameDesc")
        val redditLink = intent.getStringExtra("redditLink")
        val webLink = intent.getStringExtra("webLink")
        val score = intent.getStringExtra("score")
        val type = intent.getStringExtra("type")
        initViews(name,imageUrl,gameDesc,redditLink,webLink) // intent'den verileri alma
        gameButton.setOnClickListener {
            finish()
        }
        favButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name",name)
            bundle.putString("imageUrl",imageUrl)
            bundle.putString("gameDesc",gameDesc)
            bundle.putString("redditLink",redditLink)
            bundle.putString("webLink",webLink)
            bundle.putString("score",score)
            bundle.putString("type",type)
            favFragment.arguments = bundle // ArrayListe ekle varsa sil
            supportFragmentManager.beginTransaction().add(R.id.activity_det,favFragment)
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