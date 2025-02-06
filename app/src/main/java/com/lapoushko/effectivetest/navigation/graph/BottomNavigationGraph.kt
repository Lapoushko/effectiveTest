package com.lapoushko.effectivetest.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lapoushko.effectivetest.favourite.FavouriteScreen
import com.lapoushko.effectivetest.main.MainScreen
import com.lapoushko.effectivetest.message.MessageScreen
import com.lapoushko.effectivetest.navigation.model.ScreenBar
import com.lapoushko.effectivetest.profile.ProfileScreen
import com.lapoushko.effectivetest.respond.RespondScreen

/**
 * @author Lapoushko
 */

@Composable
fun BottomNavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = ScreenBar.Main.route
    ){
        composable(route = ScreenBar.Main.route) {
            MainScreen()
        }
        composable(route = ScreenBar.Favourite.route) {
            FavouriteScreen()
        }
        composable(route = ScreenBar.Respond.route) {
            RespondScreen()
        }
        composable(route = ScreenBar.Message.route) {
            MessageScreen()
        }
        composable(route = ScreenBar.Profile.route) {
            ProfileScreen()
        }
    }
}