package com.darwish.prayertimes.navigation

import android.app.Activity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NavigationServiceTest {

    @Mock
    private lateinit var mockActivity: Activity

    private lateinit var navigationService: NavigationService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        `when`(mockActivity.localClassName)
            .thenReturn("mockClassName")

        navigationService = NavigationService(mockActivity)
    }

    @Test
    fun navigationService_NavigateToCitiesActivity_Succeeds() {

        navigationService.navigateToCitiesActivity()

        verify(mockActivity, times(1)).startActivity(ArgumentMatchers.any())
        verify(mockActivity, times(1)).finish()
    }

    @Test
    fun navigationService_NavigateToPrayerTimesActivity_Succeeds() {

        val navigationService = NavigationService(mockActivity)

        val latitude = 50.0
        val longitude = 50.0

        navigationService.navigateToPrayerTimesActivity(latitude, longitude)

        verify(mockActivity, times(1)).startActivity(ArgumentMatchers.any())
        verify(mockActivity, times(1)).finish()
    }
}