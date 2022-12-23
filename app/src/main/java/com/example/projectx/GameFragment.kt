package com.example.projectx

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectx.Models.GameModel
import com.example.projectx.Models.GamesApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GameFragment() : Fragment()  ,onClickListener {
    lateinit var rvGames : RecyclerView
    lateinit var gameAdapter: GameAdapter

    lateinit var searchView: SearchView

    private val BASE_URL = "https://api.rawg.io/api/"
    //private var page: Int = 1
    //private var currentSearchQuery : String? = null

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        //önce bu şekildeydi direkt string olarak almak istediğimiz için
        //.addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container , false)
        /*if(resources.configuration.equals(Configuration.ORIENTATION_PORTRAIT)){
            rvGames.layoutManager = GridLayoutManager(context, 1)
        }
        else{
            rvGames.layoutManager = GridLayoutManager(context, 2)
        }*/

        // Adding the games to the list:
        searchView = view.findViewById(R.id.idSV)


        val searchPlateId = searchView.context.resources.getIdentifier("android:id/search_plate", null, null)
        val searchPlate = searchView.findViewById<View>(searchPlateId)
        searchPlate?.setBackgroundColor(Color.TRANSPARENT)


        callApi(view,null)



       searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {

                    callApi(view, query)
                    return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
               if(newText!!.length > 3)
               {
                   callApi(view, newText)
               }
                else{
                   callApi(view, null)
                }
                return false
            }
        })

       /* val layoutManager = LinearLayoutManager(view.context)
        var loading = true
        var pastVisiblesItems: Int
        var visibleItemCount: Int
        var totalItemCount: Int

        rvGames.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.v("...", "Last Item Wow !")
                            page = page + 1
                            callApi(view,null)
                            loading = true
                        }
                    }
                }
            }
        })*/



        return view
    }

    fun showGames(view : View, list: List<GameModel>){
        rvGames = view.findViewById(R.id.rvGames)

        //rvGames.setHasFixedSize(true)
        rvGames.layoutManager = LinearLayoutManager(view.context)
        gameAdapter = GameAdapter(list,this) // alttaki ile birleştirilebilir
        rvGames.adapter = gameAdapter
    }

    fun callApi(view : View, query : String?){
        val apiService = retrofit.create(GameApiService::class.java)

        val call = apiService.getGames(key = "f11caa5ea61840b99a7be5ae1f243d15", 1, page_size = 10,query,null,null)

        // call objesini async bir şekilde çağırmak için enqueue kullanırız
        call.enqueue(object: Callback<GamesApiResponse> {
            override fun onResponse(call: Call<GamesApiResponse>, response: Response<GamesApiResponse>) {
                // başarılı bir şekilde cevap aldıysak

                if(response.code() == 200){
                    // httpde body'de veri döner
                    val userList = response.body()!!.results
                    showGames(view,userList)

                    Log.e("API",userList.toString())
                }
                else{
                    Log.e("API","REQUEST FAIL")
                }
            }

            override fun onFailure(call: Call<GamesApiResponse>, t: Throwable) {

                Log.e("API","NO GAME FOUND")
            }

        })
    }



    // ON CLİCK METHOT OGUZ
    override fun onGameClickListener(position: Int, v: View?) {
        val actv = v?.context as AppCompatActivity // viewin activitisini döndür
        //v.setBackgroundColor(0xE0E0E0)

        val intent = Intent(actv,DetailActivity::class.java) // intent ile o positiona göre activitye data gönder

        val apiService = retrofit.create(GameApiService::class.java)
        val call : Call<GameModel> = apiService.getGameById(gameAdapter.games[position].id,"f11caa5ea61840b99a7be5ae1f243d15")
        call.enqueue(object: Callback<GameModel> {
            override fun onResponse(call: Call<GameModel>, response: Response<GameModel>) {
                // başarılı bir şekilde cevap aldıysak

                if(response.code() == 200){
                    val game = response.body()
                    intent.putExtra("game",game as GameModel)
                    startActivity(intent)
                }
                else{
                    Log.e("API","REQUEST FAIL")
                }
            }

            override fun onFailure(call: Call<GameModel>, t: Throwable) {
                Log.e("API","NO GAME FOUND")
            }

        })
       // Log.e("IDDD" ,gameAdapter.games[position].id.toString())
       // intent.putExtra("name",gameAdapter.games[position].name)

    } // on click end
}