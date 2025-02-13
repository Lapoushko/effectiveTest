package com.lapoushko.feature.component

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.common.theme.Green
import com.lapoushko.common.theme.Grey1
import com.lapoushko.common.theme.Grey3
import com.lapoushko.common.theme.Grey4
import com.lapoushko.common.theme.SpecialBlue
import com.lapoushko.common.theme.Typography
import com.lapoushko.common.theme.White
import com.lapoushko.common.theme.standardPadding
import com.lapoushko.common.R
import com.lapoushko.feature.model.AddressItem
import com.lapoushko.feature.model.ExperienceItem
import com.lapoushko.feature.model.VacancyItem
import com.lapoushko.feature.util.formatDate
import com.lapoushko.feature.util.getDeclination

/**
 * @author Lapoushko
 */
@Composable
fun VacancyCard(
    vacancyItem: VacancyItem,
    onClick: () -> Unit,
    onFavouriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClick() },
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
                        IconFavourite(onClick = { onFavouriteClick() }, isFavourite = isFavourite)
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title, color = White, style = Typography.titleSmall)
                    if (lookingNumber.isEmpty()) {
                        IconFavourite(onClick = { onFavouriteClick() }, isFavourite = isFavourite)
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
                Text(
                    text = "Опубликовано ${formatDate(publishDate)}",
                    color = Grey3,
                    style = Typography.bodyMedium
                )
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
            onClick = { onClick() }
        ) {
            Text(text = "Откликнуться", style = Typography.bodyMedium)
        }
    }
}

@Composable
private fun IconFavourite(
    onClick: () -> Unit,
    isFavourite: Boolean
) {
    var isFav by remember { mutableStateOf(isFavourite) }

    val tint = remember(isFav) {
        if (isFav) SpecialBlue else Grey4
    }

    val painter = if (isFav) {
        painterResource(R.drawable.favourite_active)
    } else {
        painterResource(R.drawable.favourite_not_active)
    }

    Icon(
        modifier = Modifier
            .size(24.dp)
            .clickable {
                onClick()
                isFav = !isFav
            },
        contentDescription = null,
        painter = painter,
        tint = tint
    )
}

@Preview
@Composable
fun VacancyCardPreview() {
    VacancyCard(
        VacancyItem(
            id = "",
            lookingNumber = "Сейчас просматривает 3 ${getDeclination(3, "человек")}",
            title = "UI/UX Designer",
            address = AddressItem(town = "Минск", street = "улица Бирюзова", house = "4/5"),
            company = "Мобирикс",
            experience = ExperienceItem("Опыт от 1 до 3 лет", "1–3 года"),
            publishDate = "Опубликовано ${formatDate("2024-02-20")}",
            salary = "1500-2900 Br",
            isFavourite = false
        ),
        onClick = {},
        onFavouriteClick = {}
    )
}