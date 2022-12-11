package com.example.projectx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindViews()
        val name = intent.getStringExtra("name")
        val imageUrl = intent.getStringExtra("imageUrl")
        val gameDesc = intent.getStringExtra("gameDesc")
        val redditLink = intent.getStringExtra("redditLink")
        val webLink = intent.getStringExtra("webLink")
        initViews(name,imageUrl,gameDesc,redditLink,webLink) // intent'den verileri alma
    }
    fun bindViews(){ //bind
        imageDetail = findViewById(R.id.imageDetail)
        gameDescr =findViewById(R.id.gameDesc)
        gameTitle = findViewById(R.id.gameTitle)
        redditLinkText = findViewById(R.id.redditLink)
        webLinkText = findViewById(R.id.webLink)
    }
    fun initViews(name:String?,imageUrl:String?,gameDesc: String?,redditLink: String?,webLink:String?){
        gameTitle.text =name // oyun adı
        Glide.with(imageDetail).load(imageUrl).into(imageDetail) // oyun resmi url'den
        gameDescr.text = gameDesc // oyun açıklaması
        val html = "<a href="+redditLink+">Visit reddit</a>" // web ve reddit linki böyle formatlandı. Xmlde textler clickable yapıldı
        val html2 = "<a href="+webLink+">Visit web</a>"
        webLinkText.text = (Html.fromHtml(html2))
        redditLinkText.text = (Html.fromHtml(html))
        redditLinkText.movementMethod= LinkMovementMethod.getInstance()// clickable metod
        webLinkText.movementMethod= LinkMovementMethod.getInstance()
    }
}