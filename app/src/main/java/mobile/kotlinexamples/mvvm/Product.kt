package mobile.kotlinexamples.mvvm

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("cityname")
    val name: String,
    @SerializedName("citynameto")
    val eEmployeeCodeNumber: String)