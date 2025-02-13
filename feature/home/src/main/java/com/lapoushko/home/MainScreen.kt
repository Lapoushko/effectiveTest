@file:OptIn(ExperimentalMaterial3Api::class)

package com.lapoushko.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lapoushko.common.theme.Black
import com.lapoushko.common.theme.Grey3
import com.lapoushko.common.theme.SpecialBlue
import com.lapoushko.common.theme.Typography
import com.lapoushko.common.theme.White
import com.lapoushko.common.theme.sizeIcon
import com.lapoushko.common.theme.standardPadding
import com.lapoushko.common.R
import com.lapoushko.feature.component.CustomSearchBar
import com.lapoushko.feature.component.RecommendationBlock
import com.lapoushko.feature.component.VacancyCard
import com.lapoushko.feature.util.StatusLoading
import com.lapoushko.feature.util.getDeclination

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
    val countVacancies = viewModel.state.countVacancies
    val status = viewModel.state.status
    Scaffold(
        containerColor = Black,
    ) { innerPadding ->
        if (status == StatusLoading.LOADING){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = SpecialBlue)
            }
        } else{
            PullToRefreshBox(
                onRefresh = {
                    viewModel.loadVacancies()
                },
                isRefreshing = status == StatusLoading.LOADING
            ) {
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
                                    VacancyCard(
                                        vacancy, onClick = { handler.onToDetail(vacancy) },
                                        onFavouriteClick = { viewModel.handleVacancySave(vacancy) }
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
                    item {
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
                                text = "Ещё $countVacancies ${getDeclination(countVacancies, "вакансия")}",
                                style = Typography.bodyMedium,
                                color = White
                            )
                        }
                    }
                }
            }
        }
    }
}