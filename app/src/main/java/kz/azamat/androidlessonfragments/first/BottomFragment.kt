package kz.azamat.androidlessonfragments.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kz.azamat.androidlessonfragments.R


class BottomFragment : Fragment() {

    private lateinit var bottomTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomTextView = view.findViewById(R.id.bottomTextView)

        parentFragmentManager.setFragmentResultListener("top_fragment", this) { _, result ->
            val value = result.getString("value", "0")
            bottomTextView.text = "Value: $value"
        }
    }

    fun setCountValue(value: String) {
        bottomTextView.text = "Value: $value"
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            BottomFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}