package com.darwish.prayertimes.cities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.darwish.prayertimes.R
import timber.log.Timber

/**
Activity that manages the selection of the user's city to get a user's approximate latitude and
longitude for prayer times calculations
 */
class CitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
    }
}
