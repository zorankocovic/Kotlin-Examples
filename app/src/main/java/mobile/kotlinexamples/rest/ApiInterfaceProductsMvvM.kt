package mobile.kotlinexamples.rest

import mobile.kotlinexamples.mvvm.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiInterfaceProductsMvvM {
    @GET("phpjson.php")
    // fun getPhotos(): Call<List<DataModel>>
    fun getPhotos(@Query("j") action: String): Call<List<Product>>
}