package com.lapoushko.home

import com.lapoushko.feature.model.VacancyItem

/**
 * @author Lapoushko
 */
class MainScreenHandler(
    private val onToDetail: (VacancyItem) -> Unit,
    private val onToSelection: () -> Unit
) {
    fun onToDetail(vacancy: VacancyItem){
        onToDetail.invoke(vacancy)
    }

    fun onToSelection(){
        onToSelection.invoke()
    }
}