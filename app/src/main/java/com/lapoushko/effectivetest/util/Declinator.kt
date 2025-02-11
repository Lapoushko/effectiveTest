package com.lapoushko.effectivetest.util

/**
 * @author Lapoushko
 */
fun getDeclination(count: Int, word: String): String {
    val forms = WordsForDeclination.entries.find { word.lowercase() in it.forms }?.forms
        ?: return word
    return when {
        count % 100 in 11..19 -> forms[2]
        count % 10 == 1 -> forms[0]
        count % 10 in 2..4 -> forms[1]
        else -> forms[2]
    }
}

private enum class WordsForDeclination(val forms: List<String>) {
    VACANCY(listOf("вакансия", "вакансии", "вакансий")),
    PERSON(listOf("человек", "человека", "человек"))
}