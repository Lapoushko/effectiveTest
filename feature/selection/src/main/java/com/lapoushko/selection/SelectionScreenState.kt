package com.lapoushko.selection

import com.lapoushko.feature.model.VacancyItem
import com.lapoushko.feature.util.StatusLoading

/**
 * @author Lapoushko
 */
interface SelectionScreenState {
    val vacancies: List<VacancyItem>
    val status: StatusLoading
}