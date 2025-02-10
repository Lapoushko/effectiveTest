package com.lapoushko.effectivetest.selection

import com.lapoushko.effectivetest.model.VacancyItem

/**
 * @author Lapoushko
 */
interface SelectionScreenState {
    val vacancies: List<VacancyItem>
}