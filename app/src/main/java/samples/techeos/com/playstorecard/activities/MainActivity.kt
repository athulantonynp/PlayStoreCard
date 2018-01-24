package samples.techeos.com.playstorecard

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import samples.techeos.com.playstorecard.adapter.SampleAdapter
import samples.techeos.com.playstorecard.beans.InnerData
import samples.techeos.com.playstorecard.extension.CustomScrollListner
import samples.techeos.com.playstorecard.extension.random
import samples.techeos.com.playstorecard.gravitysnaphelper.GravitySnapHelper

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter:SampleAdapter
    private var urlList= listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateUrlList()
        initiateRecyclerView()
        decorateCardView()

    }

    private fun decorateCardView() {

        rl_back.setBackgroundColor(Color.parseColor("#0097A7"))
        Glide.with(this).load("https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/topic_images/2015/android-apps-topic.png?itok=gRZTqteM&timestamp=1444304563")
                .into(iv_back)
    }

    private fun generateUrlList() {

        urlList= listOf("https://image.flaticon.com/icons/png/512/196/196138.png",
                "https://www.shareicon.net/data/2016/07/12/795028_identity_512x512.png",
                "http://www.directmarketinglistsaustralia.com.au/wp-content/uploads/2017/04/first-aid-kit.png",
                "http://theieltscoach.com/wp-content/uploads/2015/03/Video-Production-Icon-Round1-300x300.png")
    }


    private fun initiateRecyclerView() {
        rv_main.isNestedScrollingEnabled=true
        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main.layoutManager=linearLayoutManager
        adapter= SampleAdapter(createSampleData())
       rv_main.addOnScrollListener(CustomScrollListner(iv_back))
        rv_main.adapter=adapter
        val snapHelper=GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(rv_main)

    }

    private fun createSampleData(): ArrayList<InnerData> {

        val list= arrayListOf<InnerData>()

        for (i in 1..10){
            val data:InnerData= InnerData("Title"+i, urlList.random()!!)
            list.add(data)

        }
        return list
    }
}
