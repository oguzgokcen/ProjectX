package com.example.projectx


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    lateinit var gameButton : Button
    lateinit var favouritesButton : Button
    lateinit var gameFragment : GameFragment
    lateinit var favouritesFragment : Favourites

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragmentsAndAssignGameFirst()
        bindButtons()
        setButtonsListeners()
    }

    private fun createFragmentsAndAssignGameFirst(){
        gameFragment = GameFragment()
        favouritesFragment = Favourites()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, gameFragment)
            commit()
        }
    }

    private fun bindButtons(){
        gameButton = findViewById(R.id.gameButton)
        favouritesButton = findViewById(R.id.favouritesButton)
    }

    fun setButtonsListeners(){

        gameButton.setOnClickListener {
            gameButton.setTextColor(getApplication().getResources().getColor(R.color.activebuttonbluecolor))
            favouritesButton.setTextColor(getApplication().getResources().getColor(R.color.notactivebuttonbluecolor))
            gameButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gamebuttondrawable, 0, 0);
            favouritesButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.favnotselecteddrawable, 0, 0);
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, gameFragment)
                commit()
            }
        }

        favouritesButton.setOnClickListener {
            favouritesButton.setTextColor(getApplication().getResources().getColor(R.color.activebuttonbluecolor))
            gameButton.setTextColor(getApplication().getResources().getColor(R.color.notactivebuttonbluecolor))
            gameButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.gamenotselectedbuttondrawable, 0, 0);
            favouritesButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.favdrawable, 0, 0);
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, favouritesFragment)
                commit()
            }
        }

    }

}