package com.darwish.prayertimes.citiesscreen

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.darwish.prayertimes.R
import com.darwish.prayertimes.cities.CitiesActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class CitiesActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun initValidString() {
        ActivityScenario.launch(CitiesActivity::class.java)
    }

    @Test
    fun testStringContentAreCorrect() {
        onView(withId(R.id.message_title)).check(matches(withText(R.string.feature_not_available_title)))
        onView(withId(R.id.message_body)).check(matches(withText(R.string.feature_not_available_body)))
    }

    @Test
    fun testDividerExists() {
        onView(withId(R.id.title_horizontal_divider)).check(matches(isDisplayed()))
    }
}
