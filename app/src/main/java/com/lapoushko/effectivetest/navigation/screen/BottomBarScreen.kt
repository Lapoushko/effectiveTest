package com.lapoushko.effectivetest.navigation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lapoushko.effectivetest.navigation.extension.AddItem
import com.lapoushko.effectivetest.navigation.graph.BottomNavigationGraph
import com.lapoushko.effectivetest.navigation.model.ScreenBar

/**
 * @author Lapoushko
 */

@Composable
fun BottomBarScreen(
    navController: NavHostController,
    viewModel: BottomBarScreenViewModel = hiltViewModel()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screens = listOf(
        ScreenBar.Main.route,
        ScreenBar.Favourite.route,
        ScreenBar.Respond.route,
        ScreenBar.Message.route,
        ScreenBar.Profile.route
    )

    val showBottomBar = currentDestination?.route in screens

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                BottomBar(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            BottomNavigationGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    viewModel: BottomBarScreenViewModel?
) {
    val items = listOf(
        ScreenBar.Main,
        ScreenBar.Favourite,
        ScreenBar.Respond,
        ScreenBar.Message,
        ScreenBar.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    val countQueries by viewModel?.countQueries?.collectAsState(initial = 0)
        ?: remember { mutableIntStateOf(0) }


    NavigationBar {
        items.forEach { screen ->
            val badges by derivedStateOf { if (screen == ScreenBar.Favourite) countQueries else 0 }
            AddItem(
                screen = screen,
                destination = destination,
                navController = navController,
                badges = badges
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomBarScreen(
        rememberNavController(),
        hiltViewModel()
    )
}