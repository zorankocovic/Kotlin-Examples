package mobile.jetpackrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.LinearLayout
import androidx.appcompat.widget.ThemedSpinnerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import mobile.jetpackrecycleview.fragments.PassDataFragmentsMainClass
import mobile.jetpackrecycleview.jetpack.Jetpackrecycleview
import mobile.jetpackrecycleview.model.DataModel
import mobile.jetpackrecycleview.model.adapter.SectionAdapter
import mobile.jetpackrecycleview.mvvm.Mvvm_Activity
import mobile.jetpackrecycleview.rest.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jatpack_button = findViewById(R.id.jatpack_button) as Button
        val passdata_button = findViewById(R.id.passingdata_button) as Button
        val simplemvvm_button = findViewById(R.id.mvvm_button) as Button
        jatpack_button.setOnClickListener {

            val showPhotoIntent = Intent(getApplicationContext(), Jetpackrecycleview::class.java)

            startActivity(showPhotoIntent)

        }


        passdata_button.setOnClickListener {

            val showPhotoIntent = Intent(getApplicationContext(), PassDataFragmentsMainClass::class.java)

            startActivity(showPhotoIntent)

        }

        simplemvvm_button.setOnClickListener {

            val showPhotoIntent = Intent(getApplicationContext(), Mvvm_Activity::class.java)

            startActivity(showPhotoIntent)

        }



    }


}
