package com.lapoushko.effectivetest.main

import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.util.StatusLoading

/**
 * @author Lapoushko
 */
interface MainScreenState{
    val vacancies: List<VacancyItem>
    val countVacancies: Int
    val offers: List<OfferItem>
    val status: StatusLoading
}