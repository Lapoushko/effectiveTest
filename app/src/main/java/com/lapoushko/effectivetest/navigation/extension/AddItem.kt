package com.lapoushko.effectivetest.navigation.extension

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.lapoushko.effectivetest.navigation.model.ScreenBar
import com.lapoushko.effectivetest.ui.theme.Grey4
import com.lapoushko.effectivetest.ui.theme.SpecialBlue
import com.lapoushko.effectivetest.ui.theme.Typography

/**
 * @author Lapoushko
 */
@Composable
fun RowScope.AddItem(
    screen: ScreenBar,
    destination: NavDestination?,
    navController: NavHostController,
    badges: Int = 0
) {
    NavigationBarItem(
        selected = destination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BadgedBox(
                    badge = {
                        if (badges > 0) {
                            Badge(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            ) {
                                Text(text = "$badges", style = Typography.labelSmall)
                            }
                        }
                    }
                ) {
                    if (destination?.hierarchy?.any { it.route == screen.route } == true) {
                        CustomNavIcon(
                            id = screen.setIcon,
                            title = screen.title,
                            tint = SpecialBlue
                        )
                    } else {
                        CustomNavIcon(
                            id = screen.unsetIcon ?: screen.setIcon,
                            title = screen.title,
                            tint = Grey4
                        )
                    }
                }
            }
        },
        label = {
            Text(
                text = screen.title,
                style = Typography.bodySmall,
                color = Grey4
            )
        }, colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent
        )
    )
}

@Composable
private fun CustomNavIcon(
    id: Int,
    title: String,
    tint: Color
) {
    Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(id),
        contentDescription = title,
        tint = tint
    )
}