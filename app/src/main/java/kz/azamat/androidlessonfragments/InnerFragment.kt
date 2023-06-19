package kz.azamat.androidlessonfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text


class InnerFragment : Fragment() {

    lateinit var count: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            count = it.getString("VALUE_KAY", "0")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.countText).text = "Fragment count $count"
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            InnerFragment().apply {
                arguments = Bundle().apply {
                    putString("VALUE_KAY", param1)
                }
            }
    }
}