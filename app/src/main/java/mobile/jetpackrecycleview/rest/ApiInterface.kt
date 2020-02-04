package mobile.jetpackrecycleview.rest

import mobile.jetpackrecycleview.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface ApiInterface {

    @GET("phpjson.php")
    // fun getPhotos(): Call<List<DataModel>>
    fun getPhotos(@Query("j") action: String): Call<List<DataModel>>
}