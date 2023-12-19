package mobile.kotlinexamples.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmentsend_activity.view.*
import mobile.kotlinexamples.R

class FragmentSend  : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragmentsend_activity, container, false) as ViewGroup
        communicator = activity as Communicator
        rootView.btnSend.setOnClickListener {
            communicator.passData(rootView.editText.text.toString(),rootView.editquantity.text.toString(),rootView.editprice.text.toString())



        }
        return rootView
    }
}