package com.lapoushko.effectivetest

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.lapoushko.effectivetest.navigation.screen.BottomBarScreen
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Lapoushko
 */
@HiltAndroidApp
class App : Application(){
    @Composable
    fun Host(){
        val navController = rememberNavController()
        BottomBarScreen(navController)
    }
}