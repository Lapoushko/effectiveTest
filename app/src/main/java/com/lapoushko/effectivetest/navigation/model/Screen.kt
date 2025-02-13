package com.lapoushko.effectivetest.navigation.model

import com.lapoushko.feature.model.VacancyItem
import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
sealed class Screen {
    @Serializable
    data object Selection : Screen()

    @Serializable
    data class VacancyDetail(val vacancy: VacancyItem): Screen()
}