package com.lapoushko.effectivetest.main

import androidx.navigation.NavHostController
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.navigation.model.Screen

/**
 * @author Lapoushko
 */
class MainScreenHandler(private val navController: NavHostController) {
    fun onToDetail(vacancy: VacancyItem){
        navController.navigate(Screen.VacancyDetail(vacancy))
    }

    fun onToSelection(){
        navController.navigate(Screen.Selection)
    }
}