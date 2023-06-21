package kz.azamat.androidlessonfragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kz.azamat.androidlessonfragments.R


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.toSecondScreenButton).setOnClickListener {
            val action = HomeFragmentDirections.actionNavigateToSecondFragment("Azamat", 10)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.toThirdScreenButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_thirdFragment)
        }

        view.findViewById<Button>(R.id.toDialogButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_appDialog)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}