@file:OptIn(ExperimentalMaterial3Api::class)

package com.lapoushko.feature.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.common.R
import com.lapoushko.common.theme.Grey2
import com.lapoushko.common.theme.Grey3
import com.lapoushko.common.theme.Typography
import com.lapoushko.common.theme.miniShape
import com.lapoushko.common.theme.sizeIcon

/**
 * @author Lapoushko
 */

@Composable
fun CustomSearchBar(
    text: String,
    leadingIcon: @Composable (() -> Unit)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            SearchInputField(text, leadingIcon)
        }
        FilterButton()
    }
}

@Composable
fun SearchInputField(
    text: String,
    leadingIcon: @Composable (() -> Unit)
) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(text = text, style = Typography.bodyMedium, overflow = TextOverflow.Ellipsis) },
        leadingIcon = leadingIcon,
        shape = miniShape,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Grey2,
            focusedContainerColor = Grey2,
            unfocusedTextColor = Grey3,
            focusedTextColor = Grey3,
            unfocusedPlaceholderColor = Grey3,
            focusedPlaceholderColor = Grey3,
            disabledPlaceholderColor = Grey3,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = VisualTransformation.None
    )
}

@Composable
private fun FilterButton() {
    FloatingActionButton(
        modifier = Modifier.size(60.dp),
        shape = miniShape,
        containerColor = Grey2,
        contentColor = Grey3,
        onClick = {}
    ) {
        Icon(
            modifier = Modifier.size(sizeIcon),
            painter = painterResource(R.drawable.filter_icon),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun CustomSearchBarPreview() {
    CustomSearchBar(text = "Должность, ключевые слова",
    leadingIcon = {
        Icon(
            painterResource(R.drawable.search_button),
            contentDescription = null,
            modifier = Modifier.size(sizeIcon),
            tint = Grey3
        )
    })
}