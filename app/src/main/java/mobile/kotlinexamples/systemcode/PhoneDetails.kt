package mobile.kotlinexamples.systemcode

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import mobile.kotlinexamples.R
import android.Manifest.permission.READ_PHONE_NUMBERS
import android.Manifest.permission.READ_PHONE_STATE
import android.Manifest.permission.READ_SMS
import android.Manifest.permission.READ_PHONE_NUMBERS;
import android.Manifest.permission.READ_PHONE_STATE;
import android.Manifest.permission.READ_SMS;
import android.widget.Toast

class PhoneDetails  : AppCompatActivity() {
    var phone_number: TextView? = null
    var phone_imei: TextView? = null
    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phone_details)
        val actionbar = supportActionBar

      //  actionbar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#11FF01")))
        actionbar!!.title = "Phone details"
        // TextView reference
        phone_number = findViewById(R.id.phone_number)
        phone_imei = findViewById(R.id.phone_imei)
        GetNumber()

    }

    fun GetNumber() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_NUMBERS
            ) ==
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission check
            Toast.makeText(this,"hh", Toast.LENGTH_LONG).show()
            // Create obj of TelephonyManager and ask for current telephone service
            val telephonyManager = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
            val phoneNumber = telephonyManager.line1Number
            Toast.makeText(this,phoneNumber, Toast.LENGTH_LONG).show()
            phone_number!!.text = phoneNumber
            return
        } else {
            // Ask for permission


            requestPermission()
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.READ_SMS,
                    Manifest.permission.READ_PHONE_NUMBERS,
                    Manifest.permission.READ_PHONE_STATE
                ), 100
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 -> {

                if (ActivityCompat.checkSelfPermission(this,  Manifest.permission.READ_SMS) !=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.READ_PHONE_NUMBERS
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.READ_PHONE_STATE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
               // val telephonyManager = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager

                //val phoneNumber = telephonyManager.line1Number
               // Toast.makeText(this,phoneNumber, Toast.LENGTH_LONG).show()
               //phone_number!!.text = phoneNumber
                val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
                val imei = if (android.os.Build.VERSION.SDK_INT >= 26) {

                    telephonyManager.imei
                  //  Toast.makeText(this, telephonyManager.imei, Toast.LENGTH_LONG).show()
                    phone_imei!!.text = telephonyManager.imei
                } else {

                    telephonyManager.deviceId
                   // Toast.makeText(this, telephonyManager.deviceId, Toast.LENGTH_LONG).show()
                    phone_imei!!.text = telephonyManager.imei               }



            }
            else -> throw IllegalStateException("Unexpected value: $requestCode")
        }
    }
}