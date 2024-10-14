package mobile.kotlinexamples.systemcode

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mobile.kotlinexamples.R

class ScreenWidtHeight : AppCompatActivity() {
    lateinit var msgTV: TextView
    var displayMetrics = DisplayMetrics()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screenwidtheight_activity)
        val actionbar = supportActionBar
        actionbar!!.title = "Screen dimension"
        msgTV = findViewById(R.id.textdimension)
        val displayDimensions = GetScreenWidthHeight()
        displayDimensions.getScreenDimensions(this)

       /* getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels*/
        val width = displayDimensions.widthscreen
        val height = displayDimensions.heightscreen
        val dpi_screen = displayDimensions.mScreenDPI

        msgTV.text = "Width : " + width.toString() + "\n" + "Height : " + height.toString() + "\n" + "Density : " + dpi_screen.toString()



    }
}