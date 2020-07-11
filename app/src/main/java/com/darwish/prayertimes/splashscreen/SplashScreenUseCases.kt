package com.darwish.prayertimes.splashscreen

import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import com.darwish.prayertimes.location.LocationService
import com.darwish.prayertimes.navigation.NavigationService
import com.darwish.prayertimes.permission.PermissionService
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Provides helpful splash screen methods for handling navigation
 */
@ActivityContext
class SplashScreenUseCases @Inject constructor(
    private val locationService: LocationService,
    private val permissionService: PermissionService,
    private val navigationService: NavigationService
) {

    /**
     * Handles the initial app navigation prior to requesting permissions
     */
    suspend fun handleNavigation() =
        withContext(Dispatchers.Default) {

            val hasFineLocationPermission = permissionService.hasFineLocationPermission()

            if (hasFineLocationPermission) {
                Timber.i("Fine location permission present")

                navigateToPrayerTimesActivity()
            } else {
                Timber.i("Fine location permission not present")

                requestFineLocationPermission()
            }
        }

    /**
     * Handles the navigation after requesting permission
     */
    suspend fun handleRequestFineLocationPermissionResult(grantResults: IntArray) =
        withContext(Dispatchers.Default) {

            if ((grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED)
            ) {
                Timber.i("Request fine location permission accepted")
                navigateToPrayerTimesActivity()
            } else {
                Timber.i("Request fine location permission rejected")

                navigationService.navigateToCitiesActivity()
            }
        }

    /**
     * Navigates to the prayer times activity
     */
    private fun navigateToPrayerTimesActivity() {
        val locTask = locationService.getLocation()
        locTask.addOnSuccessListener { location: Location ->
            Timber.i("Latitude: ${location.latitude}")
            Timber.i("Longitude: ${location.longitude}")

            navigationService.navigateToPrayerTimesActivity(location.latitude, location.longitude)
        }
    }

    /**
     * Requests the fine location permission
     */
    private fun requestFineLocationPermission() {
        permissionService.requestFineLocationPermission()
    }
}