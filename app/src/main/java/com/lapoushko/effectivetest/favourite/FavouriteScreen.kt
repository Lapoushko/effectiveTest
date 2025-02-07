package com.lapoushko.effectivetest.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lapoushko.effectivetest.component.VacancyCard
import com.lapoushko.effectivetest.ui.theme.Black
import com.lapoushko.effectivetest.ui.theme.Grey3
import com.lapoushko.effectivetest.ui.theme.Typography
import com.lapoushko.effectivetest.ui.theme.White
import com.lapoushko.effectivetest.ui.theme.standardPadding
import com.lapoushko.effectivetest.util.getDeclination

/**
 * @author Lapoushko
 */

@Composable
fun FavouriteScreen(
    viewModel: FavouriteScreenViewModel = hiltViewModel()
) {
    val vacancies = viewModel.state.vacancies
    Scaffold(
        containerColor = Black,
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
        ) {
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
                        VacancyCard(vacancy, onClick = {})
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

@Preview
@Composable
fun FavouriteScreenPreview() {
    FavouriteScreen()
}