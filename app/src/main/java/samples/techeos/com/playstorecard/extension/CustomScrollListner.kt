package samples.techeos.com.playstorecard.extension

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.TranslateAnimation

/**
 * Created by athul on 24/1/18.
 */

class CustomScrollListner(private val view:View): RecyclerView.OnScrollListener(){

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }


    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        recyclerView?.let {
            if(it.computeHorizontalScrollOffset()!=0){

                val anim=TranslateAnimation(0.25f*(0-it.computeHorizontalScrollOffset()),
                        0.25f*(0-it.computeHorizontalScrollOffset()),0f,0f)
                anim.setFillAfter(true)
                anim.setDuration(0)
                view.startAnimation(anim)
                view.setAlpha(getAlphaForView(it));

            }else {
                view.setAlpha(1f);
            }

            }
        }

    private fun getAlphaForView(recyclerView: RecyclerView): Float {
        return recyclerView.computeHorizontalScrollOffset() * (-1.4f / recyclerView.computeHorizontalScrollExtent()) + 1f

    }

}
