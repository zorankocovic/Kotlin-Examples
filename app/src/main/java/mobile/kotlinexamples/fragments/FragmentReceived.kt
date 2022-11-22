package mobile.kotlinexamples.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragmentreceived_activity.view.*
import mobile.kotlinexamples.R

class FragmentReceived  : Fragment() {
    var inputText: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragmentreceived_activity, container, false)
        inputText = arguments?.getString("inputText")
        rootView.outPutTextView.text = inputText
        return rootView
    }
}