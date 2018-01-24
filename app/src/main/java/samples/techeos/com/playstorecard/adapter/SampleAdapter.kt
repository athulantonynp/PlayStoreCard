package samples.techeos.com.playstorecard.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import samples.techeos.com.playstorecard.R
import samples.techeos.com.playstorecard.beans.InnerData
import samples.techeos.com.playstorecard.extension.inflate

/**
 * Created by athul on 24/1/18.
 */

class SampleAdapter(private val items:ArrayList<InnerData>):
        RecyclerView.Adapter<SampleAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ViewHolder {

        val inflatedView= parent!!.inflate(R.layout.list_cell_item_card,false)
        return ViewHolder(inflatedView)

    }


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val view=holder?.itemView
        if(position==0||position==1){
            view?.let {
                it.visibility=View.INVISIBLE;
            }

        }else{

            val data=items[position-2]
            view?.let {
                it.visibility=View.VISIBLE
                Glide.with(it.context).load(data.icon).into(it.findViewById(R.id.iv_card))
                (it.findViewById(R.id.tv_card) as TextView).text=data.name
            }
        }

    }

    class ViewHolder(v:View) : RecyclerView.ViewHolder(v){

    }


    //Adding 2 more items to make them invisible on first two positions
    override fun getItemCount()= items.size+2
}