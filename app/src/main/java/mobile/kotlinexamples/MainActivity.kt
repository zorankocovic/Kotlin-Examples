package mobile.kotlinexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import mobile.kotlinexamples.fragments.PassDataFragmentsMainClass
import mobile.kotlinexamples.jetpack.Jetpackrecycleview
import mobile.kotlinexamples.model.DataModel
import mobile.kotlinexamples.mvvm.Mvvm_Activity

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jatpack_button = findViewById(R.id.jatpack_button) as Button
        val passdata_button = findViewById(R.id.passingdata_button) as Button
        val simplemvvm_button = findViewById(R.id.mvvm_button) as Button
        val popup_button = findViewById(R.id.popupbutton) as Button
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

        popup_button.setOnClickListener {

            val showPhotoIntent = Intent(getApplicationContext(), Popupwindow::class.java)

            startActivity(showPhotoIntent)

        }

    }


}
