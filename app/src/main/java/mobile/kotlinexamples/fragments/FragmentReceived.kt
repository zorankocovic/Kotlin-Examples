package mobile.kotlinexamples.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragmentreceived_activity.view.*
import mobile.kotlinexamples.R

class FragmentReceived  : Fragment() {
    var productnameText: String? = ""
    var quantityText: String? = ""
    var PriceText: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragmentreceived_activity, container, false)
        productnameText = arguments?.getString("inputText")
        quantityText = arguments?.getString("quantityText")
        PriceText = arguments?.getString("PriceText")

        rootView.productname.text = productnameText
        rootView.productquantity.text = quantityText
        rootView.priceText.text = PriceText
        return rootView
    }
}