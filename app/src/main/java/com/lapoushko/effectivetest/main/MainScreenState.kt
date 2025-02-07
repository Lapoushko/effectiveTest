package com.lapoushko.effectivetest.main

import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem

/**
 * @author Lapoushko
 */
interface MainScreenState{
    val vacancies: List<VacancyItem>
    val offers: List<OfferItem>
}