package com.lapoushko.effectivetest.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lapoushko.effectivetest.detail.VacancyDetailScreen
import com.lapoushko.effectivetest.favourite.FavouriteScreen
import com.lapoushko.effectivetest.main.MainScreen
import com.lapoushko.effectivetest.main.MainScreenHandler
import com.lapoushko.effectivetest.message.MessageScreen
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.navigation.model.Screen
import com.lapoushko.effectivetest.navigation.model.ScreenBar
import com.lapoushko.effectivetest.profile.ProfileScreen
import com.lapoushko.effectivetest.respond.RespondScreen
import com.lapoushko.effectivetest.selection.SelectionScreen
import com.lapoushko.effectivetest.selection.SelectionScreenHandler
import com.lapoushko.effectivetest.util.VacancyNavType
import kotlin.reflect.typeOf

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
            MainScreen(
                handler = MainScreenHandler(navController),
            )
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
        composable<Screen.Selection> {
            SelectionScreen(
                handler = SelectionScreenHandler(navController),
            )
        }
        composable<Screen.VacancyDetail>(
            typeMap = mapOf(typeOf<VacancyItem>() to VacancyNavType)
        ) { backStackEntry ->
            val vacancy = backStackEntry.toRoute<Screen.VacancyDetail>()
            VacancyDetailScreen(vacancy.vacancy)
        }
    }
}