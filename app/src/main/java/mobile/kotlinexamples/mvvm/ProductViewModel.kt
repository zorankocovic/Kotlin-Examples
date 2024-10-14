package mobile.kotlinexamples.mvvm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import mobile.kotlinexamples.rest.ApiClientProductsMvvM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {

    val getProductsist = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()
    val productsist: MutableLiveData<List<Product>> = getProductsist

    fun getAllProducts() {
        val call: Call<List<Product>> = ApiClientProductsMvvM.getClient.getPhotos("a")

        call.enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                getProductsist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}