package com.example.projectx

import com.example.projectx.Models.GameModel
import com.example.projectx.Models.GamesApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApiService {
    @GET("games")
    fun getGames(@Query("key") key: String, @Query("page") page: Int?, @Query("page_size") page_size: Int?,
                 @Query("search") search: String?, @Query("search_precise") search_precise: Boolean?,
                 @Query("search_exact") search_exact: Boolean?
                  ) : Call<GamesApiResponse>

    @GET("games/{id}")
    fun getGameById(
        @Path("id") id : Int,
        @Query("key") key: String
    ) : Call<GameModel>

}
