package mobile.kotlinexamples.rest

import mobile.kotlinexamples.mvvm.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiInterfaceProductsMvvM {
    @GET("66a9ad94-7ebb-45b9-af55-18ae1d2c9438")
    // fun getPhotos(): Call<List<DataModel>>
    fun getPhotos(@Query("j") action: String): Call<List<Product>>
}