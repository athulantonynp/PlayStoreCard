package samples.techeos.com.playstorecard.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import samples.techeos.com.playstorecard.R
import samples.techeos.com.playstorecard.beans.SampleData
import samples.techeos.com.playstorecard.inflate

/**
 * Created by athul on 24/1/18.
 */

class SampleAdapter(private val items:ArrayList<SampleData>):
        RecyclerView.Adapter<SampleAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ViewHolder {

        val inflatedView= parent!!.inflate(R.layout.list_cell_item_card,false)
        return ViewHolder(inflatedView)
    }




    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }





    class ViewHolder(v:View) : RecyclerView.ViewHolder(v){


    }


    //Adding 2 more items to make them invisible on first two positions
    override fun getItemCount()= items.size+2
}