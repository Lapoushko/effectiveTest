package com.lapoushko.effectivetest.model

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lapoushko.effectivetest.R
import com.lapoushko.effectivetest.ui.theme.DarkBlue
import com.lapoushko.effectivetest.ui.theme.DarkGreen
import com.lapoushko.effectivetest.ui.theme.Green


/**
 * @author Lapoushko
 */
class OfferItem(
    val id: String,
    val text: String,
    val buttonText: String
)

enum class Recommendations(val id: String, val icon: @Composable (() -> Unit)) {
    NEAR(
        id = "near_vacancies",
        icon = {
            RecommendationImage()
        }
    ),

    LEVEL_UP(
        id = "level_up_resume",
        icon = {
            RecommendationImage(R.drawable.level_up_resume)
        }
    ),
    TEMPORARY_JOB(
        id = "temporary_job",
        icon = {
            RecommendationImage(R.drawable.temporary_job)
        }
    ),
}

fun String.getIconRecommendation() = Recommendations.entries.find { it.id == this }?.icon

@Composable
private fun RecommendationImage(
    painter: Int? = null,
){
    val containerColor = if (painter != null) DarkGreen else DarkBlue
    FloatingActionButton(
        modifier = Modifier.size(32.dp),
        onClick = {},
        shape = androidx.compose.foundation.shape.RoundedCornerShape(90.dp),
        containerColor = containerColor,
        contentColor = Green
    ) {
        if (painter != null){
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(painter),
                contentDescription = null,
            )
        }
    }
}