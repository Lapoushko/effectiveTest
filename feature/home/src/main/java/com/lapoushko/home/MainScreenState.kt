package com.lapoushko.home

import com.lapoushko.feature.model.OfferItem
import com.lapoushko.feature.model.VacancyItem
import com.lapoushko.feature.util.StatusLoading

/**
 * @author Lapoushko
 */
interface MainScreenState{
    val vacancies: List<VacancyItem>
    val countVacancies: Int
    val offers: List<OfferItem>
    val status: StatusLoading
}