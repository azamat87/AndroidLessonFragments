package kz.azamat.androidlessonfragments.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kz.azamat.androidlessonfragments.R

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val topFragment = TopFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, topFragment)
            .replace(R.id.second_container, BottomFragment.newInstance())
            .commit()

    }
}