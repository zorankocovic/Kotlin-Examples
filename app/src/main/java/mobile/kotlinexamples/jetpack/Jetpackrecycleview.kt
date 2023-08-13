package mobile.kotlinexamples.jetpack
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.jatpack.*
import mobile.kotlinexamples.R
import mobile.kotlinexamples.model.DataModel
import mobile.kotlinexamples.adapter.SectionAdapter
import mobile.kotlinexamples.rest.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class Jetpackrecycleview : AppCompatActivity() {
    var dataList = ArrayList<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jatpack)
        rvRecyclerView.adapter= SectionAdapter(dataList)
        // rvRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvRecyclerView.setLayoutManager(LinearLayoutManager(this));
        getDat1a()

    }

    private fun getDat1a() {

        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos("a")
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {


                Log.d("fullnameto", response?.body()?.get(0)?.fullnameto)
                dataList.addAll(response!!.body()!!)
                //   var adapter = SectionAdapter(Helper.Companion.getListViewModelList())
                rvRecyclerView.adapter?.notifyDataSetChanged()
                // rvRecyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {

            }

        })
    }

}