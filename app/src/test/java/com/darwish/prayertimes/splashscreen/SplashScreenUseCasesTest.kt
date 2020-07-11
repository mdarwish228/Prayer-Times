package com.darwish.prayertimes.splashscreen

import android.location.Location
import com.darwish.prayertimes.location.LocationService
import com.darwish.prayertimes.navigation.NavigationService
import com.darwish.prayertimes.permission.PermissionService
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SplashScreenUseCasesTest {
    @Mock
    private lateinit var locationService: LocationService

    @Mock
    private lateinit var navigationService: NavigationService

    @Mock
    private lateinit var permissionsService: PermissionService

    @Mock
    private lateinit var mockLocationTask: Task<Location>

    @Mock
    private lateinit var mockLocation: Location

    @Captor
    private lateinit var captor: ArgumentCaptor<OnSuccessListener<Location>>

    private lateinit var splashScreenUseCases: SplashScreenUseCases

    private val latitude = 50.0
    private val longitude = 100.0

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        `when`(locationService.getLocation())
            .thenReturn(mockLocationTask)

        `when`(mockLocation.latitude)
            .thenReturn(latitude)

        `when`(mockLocation.longitude)
            .thenReturn(longitude)

        splashScreenUseCases =
            SplashScreenUseCases(locationService, permissionsService, navigationService)
    }

    @Test
    fun splashScreenUseCases_handleNavigation_NavigatesToPrayerTimesActivity() {
        runBlocking {

            `when`(permissionsService.hasFineLocationPermission())
                .thenReturn(true)

            splashScreenUseCases.handleNavigation()

            verify(mockLocationTask).addOnSuccessListener(captor.capture())
            val locationOnSuccessListener = captor.value

            locationOnSuccessListener.onSuccess(mockLocation)

            verify(navigationService, times(1))
                .navigateToPrayerTimesActivity(latitude, longitude)
        }
    }

    @Test
    fun splashScreenUseCases_handleNavigation_RequestFineLocationPermission() {
        runBlocking {
            `when`(permissionsService.hasFineLocationPermission())
                .thenReturn(false)

            splashScreenUseCases.handleNavigation()

            verify(permissionsService, times(1)).requestFineLocationPermission()
        }
    }

    @Test
    fun splashScreenUseCases_HandleRequestFineLocationPermissionResult_NavigatesToPrayerTimesActivity() {
        runBlocking {

            splashScreenUseCases.handleRequestFineLocationPermissionResult(intArrayOf(0))

            verify(mockLocationTask).addOnSuccessListener(captor.capture())
            val locationOnSuccessListener = captor.value

            locationOnSuccessListener.onSuccess(mockLocation)
            verify(navigationService, times(1))
                .navigateToPrayerTimesActivity(latitude, longitude)
        }
    }

    @Test
    fun splashScreenUseCases_HandleRequestFineLocationPermissionResult_NavigatesToCitiesActivity() {
        runBlocking {

            splashScreenUseCases.handleRequestFineLocationPermissionResult(intArrayOf())

            verify(navigationService, times(1))
                .navigateToCitiesActivity()
        }
    }
}
