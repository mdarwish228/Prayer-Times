package com.darwish.prayertimes.splashscreen

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SplashScreenActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Rule
    @JvmField
    val grantPermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    @Test
    fun happyPath() {
        ActivityScenario.launch(SplashScreenActivity::class.java)
    }
}
