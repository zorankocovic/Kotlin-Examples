package mobile.kotlinexamples.model

import com.google.gson.annotations.SerializedName


data class DataModel(


    @SerializedName("cityname")
    val name: String,
    @SerializedName("citynameto")
    val citynameto: String)