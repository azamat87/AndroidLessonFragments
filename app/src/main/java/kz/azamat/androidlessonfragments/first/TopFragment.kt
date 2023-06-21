package kz.azamat.androidlessonfragments.first

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import kz.azamat.androidlessonfragments.InnerFragment
import kz.azamat.androidlessonfragments.R


class TopFragment : Fragment(R.layout.fragment_top) {

    private lateinit var listener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var count = 0

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
//            Log.d("Log", "activity fragments " + activity?.supportFragmentManager?.fragments)
            count++

            childFragmentManager.beginTransaction()
                .replace(R.id.inner_container, InnerFragment.newInstance(count.toString()))
                .addToBackStack(null)
                .commit()

            listener.fromTopFragment(count.toString())
            Log.e("Log", "clicked: ")
        }

        view.findViewById<Button>(R.id.removeButton).setOnClickListener {
            Log.e("TAG", "onViewCreated: " + childFragmentManager.backStackEntryCount)
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
                count--
            } else {
                activity?.onBackPressed()
            }

            val result = Bundle()
            result.putString("value", count.toString())
            parentFragmentManager.setFragmentResult("top_fragment", result)
            parentFragmentManager.setFragmentResult("top_result", result)


        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = TopFragment()
    }


    interface Listener {
        fun fromTopFragment(value: String)

        fun onMoreFunc()
    }
}