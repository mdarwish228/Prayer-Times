package com.darwish.prayertimes.location

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task
import dagger.hilt.android.qualifiers.ActivityContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Provides helpful methods for providing GPS locations
 */
@ActivityContext
class LocationService @Inject constructor(
    private val fusedLocationClient: FusedLocationProviderClient
) {

    /**
     * Retrieves a location task from the fused location client. The missing permission lint
     * suppression is set because the location permissions is in the permission.PermissionService
     * in the code
     */
    @SuppressLint("MissingPermission")
    fun getLocation(): Task<Location> {
        Timber.i("Retrieving location")
        return fusedLocationClient.lastLocation
    }
}