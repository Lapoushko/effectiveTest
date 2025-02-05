package com.lapoushko.effectivetest.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.effectivetest.R
import com.lapoushko.effectivetest.model.AddressItem
import com.lapoushko.effectivetest.model.ExperienceItem
import com.lapoushko.effectivetest.model.VacancyItem
import com.lapoushko.effectivetest.ui.theme.Green
import com.lapoushko.effectivetest.ui.theme.Grey1
import com.lapoushko.effectivetest.ui.theme.Grey3
import com.lapoushko.effectivetest.ui.theme.Typography
import com.lapoushko.effectivetest.ui.theme.White
import com.lapoushko.effectivetest.ui.theme.standardPadding

/**
 * @author Lapoushko
 */
@Composable
fun VacancyCard(
    vacancyItem: VacancyItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {},
        colors = CardDefaults.cardColors(
            containerColor = Grey1
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = standardPadding)
                .padding(top = standardPadding),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            vacancyItem.apply {
                if (lookingNumber.isNotEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = lookingNumber, color = Green, style = Typography.bodyMedium)
                        Icon(
                            modifier = Modifier.size(24.dp).clickable { onClick() },
                            contentDescription = null,
                            painter = painterResource(R.drawable.favourite_not_active)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title, color = White, style = Typography.titleSmall)
                    if (lookingNumber.isEmpty()) {
                        Icon(
                            modifier = Modifier.size(24.dp).clickable { onClick() },
                            contentDescription = null,
                            painter = painterResource(R.drawable.favourite_not_active)
                        )
                    }
                }
                if (salary.isNotEmpty()) {
                    Text(text = salary, color = White, style = Typography.titleMedium)
                }
                Text(text = address.town, color = White, style = Typography.bodyMedium)
                Row {
                    Text(text = company, color = White, style = Typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        modifier = Modifier.size(16.dp),
                        contentDescription = null,
                        painter = painterResource(R.drawable.check_company),
                        tint = Grey3
                    )
                }
                Row {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        contentDescription = null,
                        painter = painterResource(R.drawable.experience),
                        tint = White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = experience.previewText,
                        color = White,
                        style = Typography.bodyMedium
                    )
                }
                Text(text = publishDate, color = Grey3, style = Typography.bodyMedium)
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(21.dp)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = standardPadding)
                .padding(bottom = standardPadding),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = White
            ),
            shape = RoundedCornerShape(50.dp),
            onClick = {}
        ) {
            Text(text = "Откликнуться", style = Typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun VacancyCardPreview() {
    VacancyCard(
        VacancyItem(
            id = "",
            lookingNumber = "Сейчас просматривает 1 человек",
            title = "UI/UX Designer",
            address = AddressItem(town = "Минск", street = "улица Бирюзова", house = "4/5"),
            company = "Мобирикс",
            experience = ExperienceItem("Опыт от 1 до 3 лет", "1–3 года"),
            publishDate = "Опубликовано 20 февраля",
            salary = "1500-2900 Br"
        ),
        onClick = {}
    )
}