package samples.techeos.com.playstorecard.beans

/**
 * Created by athul on 24/1/18.
 */

data class SampleData(val title:String,
                       val image:String,
                        val innerData:InnerData)

data class InnerData(val name:String,
                        val icon:String)