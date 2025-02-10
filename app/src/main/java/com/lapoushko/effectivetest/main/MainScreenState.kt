package com.lapoushko.effectivetest.main

import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem

/**
 * @author Lapoushko
 */
interface MainScreenState{
    val vacancies: List<VacancyItem>
    val countVacancies: Int
    val offers: List<OfferItem>
}