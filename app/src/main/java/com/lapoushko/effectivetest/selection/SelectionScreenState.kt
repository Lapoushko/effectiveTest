package com.lapoushko.effectivetest.selection

import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.util.StatusLoading

/**
 * @author Lapoushko
 */
interface SelectionScreenState {
    val vacancies: List<VacancyItem>
    val status: StatusLoading
}