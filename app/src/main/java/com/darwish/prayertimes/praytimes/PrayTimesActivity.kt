package com.darwish.prayertimes.praytimes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.darwish.prayertimes.R

/**
 * Activity for displaying the prayer times using the provided latitude and longitude coordinates
 */
class PrayTimesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pray_times)
    }
}