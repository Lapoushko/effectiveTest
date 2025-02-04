package com.lapoushko.effectivetest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lapoushko.effectivetest.R

// Set of Material typography styles to start with
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.Black,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.Black,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontWeight = FontWeight.Black,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semibold)),
        fontWeight = FontWeight.Black,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Black,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontWeight = FontWeight.Black,
        fontSize = 10.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)