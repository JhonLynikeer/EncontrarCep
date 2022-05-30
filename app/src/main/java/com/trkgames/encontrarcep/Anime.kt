package com.trkgames.encontrarcep

import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation

class Anime {

    private fun fadeIn(view: View){
        val animation = AlphaAnimation(0f,1f)
        animation.duration = 500L
        view.startAnimation(animation)
    }
    private fun fadeOut(view: View){
        val animation = AlphaAnimation(1f,0f)
        animation.duration = 500L
        view.startAnimation(animation)
    }
    fun tradeView(view1: View, view2: View){
        fadeOut(view1)
        Handler().postDelayed({
            view1.visibility = View.INVISIBLE
            view2.visibility = View.VISIBLE
            fadeIn(view2)
        }, 500L)
    }

}
