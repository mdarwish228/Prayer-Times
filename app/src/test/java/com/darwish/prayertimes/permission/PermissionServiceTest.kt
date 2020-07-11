package com.darwish.prayertimes.permission

import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PermissionServiceTest {

    @Mock
    private lateinit var mockActivity: Activity

    private lateinit var permissionService: PermissionService
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        permissionService = PermissionService(mockActivity)
    }

    @Test
    fun permissionService_HasFineLocationPermission_ReturnsTrue() {

        Mockito.`when`(
            mockActivity.checkPermission(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(PackageManager.PERMISSION_GRANTED)

        assertTrue(permissionService.hasFineLocationPermission())
    }

    @Test
    fun permissionService_HasFineLocationPermission_ReturnsFalse() {

        Mockito.`when`(
            mockActivity.checkPermission(
                ArgumentMatchers.any(),
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(PackageManager.PERMISSION_DENIED)

        assertFalse(permissionService.hasFineLocationPermission())
    }
}