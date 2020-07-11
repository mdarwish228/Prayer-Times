package com.darwish.prayertimes.di

import android.app.Activity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Module for providing location based injections
 */
@Module
@InstallIn(ActivityComponent::class)
object LocationModule {

    /**
     * provides FusedLocationProviderClient injection
     */
    @Provides
    fun provideFusedLocationClientModule(
        activity: Activity
    ): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(activity)
    }
}