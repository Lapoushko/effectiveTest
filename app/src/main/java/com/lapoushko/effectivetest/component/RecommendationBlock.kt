package com.lapoushko.effectivetest.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lapoushko.effectivetest.R
import com.lapoushko.effectivetest.model.OfferItem
import com.lapoushko.effectivetest.model.getIconRecommendation
import com.lapoushko.effectivetest.ui.theme.Green
import com.lapoushko.effectivetest.ui.theme.Grey1
import com.lapoushko.effectivetest.ui.theme.Typography
import com.lapoushko.effectivetest.ui.theme.White

/**
 * @author Lapoushko
 */

@Composable
fun RecommendationBlock(recommendation: OfferItem) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(132.dp),
        onClick = {},
        colors = CardDefaults.cardColors(
            containerColor = Grey1
        )
    ) {
        Column(modifier = Modifier.padding(start = 8.dp, end = 12.dp).fillMaxWidth()) {
            Spacer(Modifier.height(10.dp))
            if (recommendation.id.getIconRecommendation() != null) {
                recommendation.id.getIconRecommendation()?.invoke()
                Spacer(Modifier.height(16.dp))
            }
            Text(
                text = recommendation.text,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
                color = White,
                maxLines = if (recommendation.buttonText.isNotEmpty()) 2 else 3,
                overflow = TextOverflow.Ellipsis
            )
            if (recommendation.buttonText.isNotEmpty()) {
                Text(
                    modifier = Modifier.clickable {  },
                    text = recommendation.buttonText,
                    color = Green,
                    style = Typography.bodyMedium,
                )
            }
        }
    }
}

@Preview
@Composable
fun RecommendationBlockPreview() {
    RecommendationBlock(OfferItem(id = "temporary_job", text = "Поднять резюме в поиске", "Поднять"))
}