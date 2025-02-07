package com.lapoushko.effectivetest.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.lapoushko.effectivetest.R
import com.lapoushko.effectivetest.component.CustomSearchBar
import com.lapoushko.effectivetest.component.RecommendationBlock
import com.lapoushko.effectivetest.component.VacancyCard
import com.lapoushko.effectivetest.ui.theme.Black
import com.lapoushko.effectivetest.ui.theme.Grey3
import com.lapoushko.effectivetest.ui.theme.SpecialBlue
import com.lapoushko.effectivetest.ui.theme.Typography
import com.lapoushko.effectivetest.ui.theme.White
import com.lapoushko.effectivetest.ui.theme.sizeIcon
import com.lapoushko.effectivetest.ui.theme.standardPadding
import com.lapoushko.effectivetest.util.getDeclination

/**
 * @author Lapoushko
 */

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    handler: MainScreenHandler
) {
    val vacancies = viewModel.state.vacancies
    val offers = viewModel.state.offers
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
                    CustomSearchBar(text = "Должность, ключевые слова",
                        leadingIcon = {
                            Icon(
                                painterResource(R.drawable.search_button),
                                contentDescription = null,
                                modifier = Modifier.size(sizeIcon),
                                tint = Grey3
                            )
                        }
                    )
                    LazyRow {
                        items(offers) { offer ->
                            RecommendationBlock(offer)
                            Spacer(Modifier.width(8.dp))
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = standardPadding),
                    verticalArrangement = Arrangement.spacedBy(standardPadding)
                ) {
                    Text("Вакансии для вас", style = Typography.titleMedium, color = White)
                    vacancies.forEach { vacancy ->
                        VacancyCard(vacancy, onClick = { handler.onToDetail(vacancy) })
                    }
                }
                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                )
            }
            Button(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SpecialBlue,
                    contentColor = White,
                ),
                shape = RoundedCornerShape(8.dp),
                onClick = { handler.onToSelection() },
            ) {
                Text(
                    text = "Ещё ${vacancies.size} ${getDeclination(vacancies.size, "вакансия")}",
                    style = Typography.bodyMedium,
                    color = White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(handler = MainScreenHandler(rememberNavController()))
}