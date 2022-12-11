package com.example.projectx

import android.view.View
// Clickable interface for game adapter and favoruites and game Fragment
interface onClickListener {
    fun onGameClickListener(position: Int , v: View?)
}