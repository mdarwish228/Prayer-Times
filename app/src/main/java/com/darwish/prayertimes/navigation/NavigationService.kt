package com.darwish.prayertimes.navigation

import android.app.Activity
import android.content.Intent
import com.darwish.prayertimes.cities.CitiesActivity
import com.darwish.prayertimes.praytimes.PrayTimesActivity
import com.darwish.prayertimes.util.IntentMessageNames
import dagger.hilt.android.qualifiers.ActivityContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Provides helpful methods for navigating to different activities
 */
@ActivityContext
class NavigationService @Inject constructor(private val activity: Activity) {

    /**
     * Navigates from the activity supplied in the constructor to the Cities Activity
     */
    fun navigateToCitiesActivity() {
        Timber.i("Navigating to cities activity")
        val intent = Intent(activity, CitiesActivity::class.java).apply {
            putExtra(IntentMessageNames.SOURCE_INTENT_NAME, activity.localClassName)
        }

        activity.startActivity(intent)
        activity.finish()
    }

    /**
     * Navigates from the activity supplied in the constructor to the PrayerTimesActivity
     */
    fun navigateToPrayerTimesActivity(
        latitude: Double,
        longitude: Double
    ) {
        Timber.i("Navigating to prayer times activity")

        val intent = Intent(activity, PrayTimesActivity::class.java).apply {
            putExtra(IntentMessageNames.SOURCE_INTENT_NAME, activity.localClassName)
            putExtra(IntentMessageNames.LATITUDE_INTENT_NAME, latitude)
            putExtra(IntentMessageNames.LONGITUDE_INTENT_NAME, longitude)
        }

        activity.startActivity(intent)
        activity.finish()
    }
}