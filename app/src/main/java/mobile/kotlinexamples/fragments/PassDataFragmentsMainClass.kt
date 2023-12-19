package mobile.kotlinexamples.fragments
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import mobile.kotlinexamples.R

class PassDataFragmentsMainClass : AppCompatActivity(), Communicator {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passdatafragmentsmain)
        val firstFragment = FragmentSend()
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, firstFragment)
            .commit()
    }
    override fun passData(editTextInput: String,edtitquantity:String,editPrice:String) {
        val bundle = Bundle()
        bundle.putString("inputText", editTextInput)
        bundle.putString("quantityText", edtitquantity)
        bundle.putString("PriceText", editPrice)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = FragmentReceived()
        fragmentTwo.arguments = bundle
        transaction.replace(R.id.relativeLayout, fragmentTwo)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}