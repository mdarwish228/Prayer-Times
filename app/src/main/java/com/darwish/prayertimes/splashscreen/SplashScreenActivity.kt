package com.darwish.prayertimes.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.darwish.prayertimes.util.PermissionsCodes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Splash screen activity that manages which Activity a user is navigated to
 */
@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    /**
     * The splash screen service which is used to handle the splash screen activity logic
     */
    @Inject
    lateinit var splashScreenUseCases: SplashScreenUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            splashScreenUseCases.handleNavigation()
        }
    }

    /**
     * Method for handling the response from a permissions request.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            PermissionsCodes.FINE_LOCATION_PERMISSION_CODE -> {
                lifecycleScope.launch {
                    splashScreenUseCases.handleRequestFineLocationPermissionResult(grantResults)
                }
                return
            }
        }
    }
}

