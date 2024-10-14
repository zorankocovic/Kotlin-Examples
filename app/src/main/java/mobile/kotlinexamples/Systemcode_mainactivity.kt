package mobile.kotlinexamples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mobile.kotlinexamples.systemcode.PhoneDetails
import mobile.kotlinexamples.systemcode.ScreenWidtHeight



class Systemcode_mainactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.systemcode_maimenu)
        val actionbar = supportActionBar
        actionbar!!.title = "System information"
        val screenmeasures_button = findViewById(R.id.getscreenmeasures_button) as Button

        screenmeasures_button.setOnClickListener {

            val showPhotoIntent = Intent(getApplicationContext(), ScreenWidtHeight::class.java)

            startActivity(showPhotoIntent)

        }

        val phonedetails_button = findViewById(R.id.getphonedetails_button) as Button

        phonedetails_button.setOnClickListener {

            val showphonedetailsintent = Intent(getApplicationContext(), PhoneDetails::class.java)

            startActivity(showphonedetailsintent)

        }


    }


}
