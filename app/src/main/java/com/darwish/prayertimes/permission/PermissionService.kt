package com.darwish.prayertimes.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.darwish.prayertimes.util.PermissionsCodes
import dagger.hilt.android.qualifiers.ActivityContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Provides helpful methods for permission requesting and checking app permissions
 */
@ActivityContext
class PermissionService @Inject constructor(private val activity: Activity) {

    /**
     * Checks if the application has the fine location permission
     */
    fun hasFineLocationPermission(): Boolean {

        Timber.i("Retrieving fine location permission")

        if (ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return false
        }
        return true
    }

    /**
     * Requests the fine location permission for the app
     */
    fun requestFineLocationPermission() {

        Timber.i("Requesting fine location permission")

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            PermissionsCodes.FINE_LOCATION_PERMISSION_CODE
        )
    }
}