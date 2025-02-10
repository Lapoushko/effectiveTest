package com.lapoushko.effectivetest.selection

import androidx.navigation.NavHostController
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.navigation.model.Screen

/**
 * @author Lapoushko
 */
class SelectionScreenHandler(private val navController: NavHostController) {
    fun onToBack(){
        navController.popBackStack()
    }

    fun onToDetail(vacancy: VacancyItem){
        navController.navigate(Screen.VacancyDetail(vacancy))
    }
}