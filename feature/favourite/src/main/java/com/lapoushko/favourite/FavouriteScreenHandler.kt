package com.lapoushko.favourite

import com.lapoushko.feature.model.VacancyItem

/**
 * @author Lapoushko
 */
class FavouriteScreenHandler(private val onToDetail: (VacancyItem) -> Unit) {
    fun onToDetail(vacancy: VacancyItem) {
        onToDetail.invoke(vacancy)
    }
}