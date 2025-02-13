package com.lapoushko.effectivetest.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lapoushko.detail.VacancyDetailScreen
import com.lapoushko.effectivetest.navigation.model.Screen
import com.lapoushko.effectivetest.navigation.model.ScreenBar
import com.lapoushko.effectivetest.util.VacancyNavType
import com.lapoushko.favourite.FavouriteScreen
import com.lapoushko.favourite.FavouriteScreenHandler
import com.lapoushko.feature.model.VacancyItem
import com.lapoushko.home.MainScreen
import com.lapoushko.home.MainScreenHandler
import com.lapoushko.selection.SelectionScreen
import com.lapoushko.selection.SelectionScreenHandler
import kotlin.reflect.typeOf

/**
 * @author Lapoushko
 */

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenBar.Main.route
    ) {
        composable(route = ScreenBar.Main.route) {
            MainScreen(
                handler = MainScreenHandler(
                    onToDetail = { navController.navigate(Screen.VacancyDetail(it)) },
                    onToSelection = { navController.navigate(Screen.Selection) }
                ),
            )
        }
        composable(route = ScreenBar.Favourite.route) {
            FavouriteScreen(
                handler = FavouriteScreenHandler(onToDetail = {
                    navController.navigate(
                        Screen.VacancyDetail(
                            it
                        )
                    )
                })
            )
        }
        composable(route = ScreenBar.Respond.route) {
            navController.navigate(ScreenBar.Respond)
        }
        composable(route = ScreenBar.Message.route) {
            navController.navigate(ScreenBar.Message)
        }
        composable(route = ScreenBar.Profile.route) {
            navController.navigate(ScreenBar.Profile)
        }
        composable<Screen.Selection> {
            SelectionScreen(
                handler = SelectionScreenHandler(
                    onToDetail = { navController.navigate(Screen.VacancyDetail(it)) },
                    onToBack = { navController.popBackStack() }
                ),
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