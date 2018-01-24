package samples.techeos.com.playstorecard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import samples.techeos.com.playstorecard.adapter.SampleAdapter
import samples.techeos.com.playstorecard.beans.InnerData
import samples.techeos.com.playstorecard.extension.CustomScrollListner
import samples.techeos.com.playstorecard.extension.random

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter:SampleAdapter
    private var urlList= listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateUrlList()
        initiateRecyclerView()

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
        rv_main.addOnScrollListener(CustomScrollListner(cv_main))
    }

    private fun createSampleData(): ArrayList<InnerData> {

        val list= arrayListOf<InnerData>()

        for (i in 1..6){
            val data:InnerData= InnerData("Title"+i, urlList.random()!!)
            list.add(data)

        }
        return list
    }
}
