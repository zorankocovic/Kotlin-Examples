package mobile.kotlinexamples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.jatpack.*
import mobile.kotlinexamples.adapter.SectionAdapter
import mobile.kotlinexamples.fragments.PassDataFragmentsMainClass
import mobile.kotlinexamples.model.DataModel

class Popupwindow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popuwindow)
        val actionbar = supportActionBar
        actionbar!!.title = "Popup Menu"
        val popup_button = findViewById(R.id.popupbutton) as Button

        popup_button.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(this, popup_button)
            popupMenu.menuInflater.inflate(R.menu.popup_example, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_one -> {
                        Toast.makeText(this@Popupwindow, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()

                    }

                    R.id.action_two ->
                        Toast.makeText(
                            this@Popupwindow,
                            "You Clicked : " + item.title,
                            Toast.LENGTH_SHORT
                        ).show()


                    R.id.action_three -> {
                        Toast.makeText(this@Popupwindow, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()

                    }
                }
                true
            })
            popupMenu.show()
        }

        }


    }
