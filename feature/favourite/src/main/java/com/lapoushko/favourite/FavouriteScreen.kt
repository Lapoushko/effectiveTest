package com.lapoushko.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lapoushko.common.theme.Black
import com.lapoushko.common.theme.Grey3
import com.lapoushko.common.theme.Typography
import com.lapoushko.common.theme.White
import com.lapoushko.common.theme.standardPadding
import com.lapoushko.feature.component.VacancyCard
import com.lapoushko.feature.util.getDeclination

/**
 * @author Lapoushko
 */

@Composable
fun FavouriteScreen(
    viewModel: FavouriteScreenViewModel = hiltViewModel(),
    handler: FavouriteScreenHandler
) {
    val vacancies = viewModel.state.vacancies
    Scaffold(
        containerColor = Black,
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            item {
                Column {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = standardPadding),
                        verticalArrangement = Arrangement.spacedBy(standardPadding)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(32.dp)
                        )
                        Text(text = "Избранное", style = Typography.titleMedium, color = White)
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = standardPadding),
                        verticalArrangement = Arrangement.spacedBy(standardPadding)
                    ) {
                        Text(
                            "${vacancies.size} ${getDeclination(vacancies.size, "вакансия")}",
                            style = Typography.bodyMedium,
                            color = Grey3
                        )
                        vacancies.forEach { vacancy ->
                            VacancyCard(
                                vacancy, onClick = { handler.onToDetail(vacancy) },
                                onFavouriteClick = { viewModel.unsaveVacancy(vacancy) }
                            )
                        }
                    }
                    Spacer(
                        Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    )
                }
            }
        }
    }
}