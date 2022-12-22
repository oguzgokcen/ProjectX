package com.example.projectx.Models

import java.io.Serializable


data class GameModel(val metacritic: Int?, val name: String?, val background_image : String?, val slug : String?,
        val name_original : String?, val description : String?, val genres : List<GenresModel>, val id : Int,
                     val website: String?, val reddit_url: String?
    ) : Serializable
