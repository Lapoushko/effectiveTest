package com.lapoushko.effectivetest.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * @author Lapoushko
 */
fun formatDate(dateString: String): String {
    val date = parseDate(dateString)
    return formatDateToString(date)
}

private fun parseDate(dateString: String): LocalDate {
    return try {
        LocalDate.parse(dateString)
    } catch (e: Exception) {
        LocalDate.parse("1970-01-01")
    }
}

private fun formatDateToString(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))
    return date.format(formatter)
}