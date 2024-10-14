package mobile.kotlinexamples.navigation
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import mobile.kotlinexamples.R
import android.view.animation.AnimationUtils
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Bottom_navigation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var bottomSheetHelper: Bootom_sheet_class
    lateinit var bottomNav : BottomNavigationView
    var mConstraintLayout: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomnavigation)
        val actionbar = supportActionBar
         actionbar!!.title = "Bottom navigation"
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)


        navView.setNavigationItemSelectedListener(this)

        bottomSheetHelper = Bootom_sheet_class(this)
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView

        mConstraintLayout = findViewById(R.id.main_layout) as ConstraintLayout
        mConstraintLayout!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if(bottomNav.visibility == View.VISIBLE){
                    bottomNav.visibility = View.GONE
                    val animation = AnimationUtils.loadAnimation(this@Bottom_navigation, R.anim.fade_out_bottom_menu)
                    bottomNav.startAnimation(animation)


                }
                else {

                    bottomNav.visibility = View.VISIBLE
                    val animation = AnimationUtils.loadAnimation(this@Bottom_navigation, R.anim.fade_in_bottom_menu)
                    //starting the animation
                    bottomNav.startAnimation(animation)
                }
            }
        })

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Click settings", Toast.LENGTH_LONG).show()
                     //  Add here some new intent
                }
                R.id.message -> {
                    // Bottom sheet dialog
                    bottomSheetHelper.showBottomSheetDialog()

                }
                R.id.logout -> {
                    Toast.makeText(this, "Click logout", Toast.LENGTH_LONG).show()

                }

                R.id.more -> {

                 //   showPopup()
                    val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    } else {
                        drawerLayout.openDrawer(GravityCompat.START)
                    }

                }


            }
            true
        }

    }

    private fun showPopup() {

        AlertDialog.Builder(this)
            .setItems(arrayOf("Action one", "Action two")) { _, pos ->
                when (pos) {
                    0 -> {

                    }
                    1 -> {

                    }

                }
            }
            .show()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_item1 -> {
                Toast.makeText(this, "Click Item 1", Toast.LENGTH_LONG).show()


            }



            R.id.nav_item2 -> {
                Toast.makeText(this, "Click Item 2", Toast.LENGTH_LONG).show()
            }



            R.id.subitem1 -> {
                Toast.makeText(this, "Click Sub Item 1", Toast.LENGTH_LONG).show()
            }


            R.id.subitem2 -> {
                Toast.makeText(this, "Click Sub Item 2", Toast.LENGTH_LONG).show()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}