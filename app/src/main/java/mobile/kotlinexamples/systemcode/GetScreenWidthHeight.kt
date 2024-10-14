package mobile.kotlinexamples.systemcode
import android.content.Context.WINDOW_SERVICE
import android.hardware.display.DisplayManager
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


class GetScreenWidthHeight {
    var widthscreen: Int = 0
    var heightscreen: Int = 0
    var mScreenDPI: Float = 0.0f
    fun getScreenDimensions(activity: AppCompatActivity) {


       val displayMetrics = DisplayMetrics()
       val windowManager = activity.applicationContext.getSystemService(WINDOW_SERVICE) as WindowManager

       if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
           getSystemService<DisplayManager>()?.getDisplay(Display.DEFAULT_DISPLAY)
       } else {
           windowManager.defaultDisplay.getMetrics(displayMetrics)
       }
       widthscreen= displayMetrics.widthPixels
       heightscreen = displayMetrics.heightPixels
        mScreenDPI = displayMetrics.density
   }

    private fun <T> getSystemService(): DisplayManager? {
        TODO("Not yet implemented")
    }


}