package com.lapoushko.selection

import com.lapoushko.feature.model.VacancyItem

/**
 * @author Lapoushko
 */
class SelectionScreenHandler(
    private val onToBack: () -> Unit,
    private val onToDetail: (VacancyItem) -> Unit
) {
    fun onToBack() {
        onToBack.invoke()
    }

    fun onToDetail(vacancy: VacancyItem) {
        onToDetail.invoke(vacancy)
    }
}