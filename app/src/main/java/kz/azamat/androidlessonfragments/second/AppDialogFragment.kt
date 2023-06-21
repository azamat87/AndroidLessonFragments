package kz.azamat.androidlessonfragments.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import kz.azamat.androidlessonfragments.R

class AppDialogFragment: DialogFragment(R.layout.fragment_app_dialog)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}