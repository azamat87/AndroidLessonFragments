package kz.azamat.androidlessonfragments.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kz.azamat.androidlessonfragments.R

class FirstActivity : AppCompatActivity(), TopFragment.Listener {

    private lateinit var bottomFragment: BottomFragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val topFragment = TopFragment.newInstance()
        bottomFragment = BottomFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, topFragment)
            .replace(R.id.second_container, bottomFragment)
            .commit()

        supportFragmentManager.setFragmentResultListener("top_result", this) {
            _, bundle ->
            val value = bundle.getString("value", "")
            Toast.makeText(this, "RESULT $value", Toast.LENGTH_SHORT).show()
        }
    }

    override fun fromTopFragment(value: String) {
        Toast.makeText(this, "From TopFragment $value", Toast.LENGTH_SHORT).show()
        bottomFragment.setCountValue(value)
    }

    override fun onMoreFunc() {

    }
}