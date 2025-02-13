package com.lapoushko.favourite

import com.lapoushko.feature.model.VacancyItem

/**
 * @author Lapoushko
 */
interface FavouriteScreenState {
    val vacancies : List<VacancyItem>
}