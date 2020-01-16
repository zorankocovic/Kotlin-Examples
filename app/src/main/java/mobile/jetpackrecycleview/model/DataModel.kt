package mobile.jetpackrecycleview.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DataModel(


    @SerializedName("cityname")
    val name: String,
    @SerializedName("citynameto")
    val eEmployeeCodeNumber: String,
    @SerializedName("date_start")
    val thumbnailUrl: String,
    @SerializedName("fullname")
    val fullname: String,
    @SerializedName("fullnameto")
    val fullnameto: String,
    @SerializedName("mptId")
    val mptId: String)