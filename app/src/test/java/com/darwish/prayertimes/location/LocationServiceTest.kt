package com.darwish.prayertimes.location

import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Task
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LocationServiceTest {

    @Mock
    private lateinit var mockFusedLocationProviderClient: FusedLocationProviderClient

    @Mock
    private lateinit var mockLocationTask: Task<Location>

    private lateinit var locationService: LocationService


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        `when`(mockFusedLocationProviderClient.lastLocation)
            .thenReturn(mockLocationTask)

        locationService = LocationService(mockFusedLocationProviderClient)
    }

    @Test
    fun locationService_NavigateToCitiesActivity_Succeeds() {
        assertEquals(mockLocationTask, locationService.getLocation())
    }
}