@file:OptIn(ExperimentalMaterial3Api::class)

package com.lapoushko.selection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import com.lapoushko.common.theme.SpecialBlue
import com.lapoushko.common.theme.Typography
import com.lapoushko.common.theme.White
import com.lapoushko.common.theme.sizeIcon
import com.lapoushko.common.theme.standardPadding
import com.lapoushko.common.R
import com.lapoushko.feature.component.CustomSearchBar
import com.lapoushko.feature.component.VacancyCard
import com.lapoushko.feature.util.StatusLoading
import com.lapoushko.feature.util.getDeclination

/**
 * @author Lapoushko
 */

@Composable
fun SelectionScreen(
    viewModel: SelectionScreenViewModel = hiltViewModel(),
    handler: SelectionScreenHandler
) {
    val vacancies = viewModel.state.vacancies
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
                isRefreshing = status == StatusLoading.LOADING,
                onRefresh = {
                    viewModel.loadVacancies()
                },
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
                                CustomSearchBar(
                                    text = "Должность по подходящим вакансиям",
                                    leadingIcon = {
                                        Icon(
                                            painterResource(R .drawable.arrow_back),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(sizeIcon)
                                                .clickable { handler.onToBack() },
                                            tint = White
                                        )
                                    }
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        "${vacancies.size} ${getDeclination(vacancies.size, "вакансия")}",
                                        style = Typography.bodyMedium,
                                        color = White
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Text(
                                            text = "По соответствию",
                                            style = Typography.bodyMedium,
                                            color = SpecialBlue
                                        )
                                        Icon(
                                            modifier = Modifier.size(16.dp),
                                            painter = painterResource(R.drawable.sort_arrows),
                                            contentDescription = null,
                                            tint = SpecialBlue
                                        )
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
                }
            }
        }
    }
}