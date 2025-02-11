package com.lapoushko.effectivetest.favourite

import androidx.navigation.NavHostController
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.navigation.model.Screen

/**
 * @author Lapoushko
 */
class FavouriteScreenHandler(private val navController: NavHostController) {
    fun onToDetail(vacancy: VacancyItem){
        navController.navigate(Screen.VacancyDetail(vacancy))
    }
}