package com.lapoushko.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lapoushko.feature.model.VacancyItem

/**
 * @author Lapoushko
 */
@Composable
fun VacancyDetailScreen(vacancy: VacancyItem){
    Text(text = vacancy.title)
}