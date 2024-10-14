package mobile.kotlinexamples.navigation
import android.app.Activity
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.widget.Button
import mobile.kotlinexamples.R

class Bootom_sheet_class (private val activity: Activity) {

    // Function to show the BottomSheetDialog
    fun showBottomSheetDialog() {
        // Create an instance of BottomSheetDialog
        val dialog = BottomSheetDialog(activity)

        // Inflate the custom layout for the dialog
        val view = LayoutInflater.from(activity).inflate(R.layout.bottom_sheet_dialog, null)

        // Initialize the close button from the inflated layout
        val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)

        // Make the dialog non-cancelable
        dialog.setCancelable(false)

        // Set the view in the dialog
        dialog.setContentView(view)

        // Show the dialog
        dialog.show()

        // Set click listener for the close button
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
    }
}