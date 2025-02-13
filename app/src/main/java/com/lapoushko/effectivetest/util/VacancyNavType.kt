package com.lapoushko.effectivetest.util

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.lapoushko.feature.model.VacancyItem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * @author Lapoushko
 */
val VacancyNavType =
    object : NavType<VacancyItem>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): VacancyItem {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(
                    key,
                    VacancyItem::class.java
                ) as VacancyItem
            } else {
                bundle.getParcelable<VacancyItem>(key) as VacancyItem
            }
        }

        override fun parseValue(value: String): VacancyItem {
            val decodedValue = URLDecoder.decode(value, "UTF-8")
            return Json.decodeFromString(decodedValue)
        }

        override fun put(
            bundle: Bundle,
            key: String,
            value: VacancyItem
        ) {
            bundle.putParcelable(key, value)
        }

        override fun serializeAsValue(value: VacancyItem): String {
            val json = Json.encodeToString(value)
            return URLEncoder.encode(json, "UTF-8")
        }

        override val name: String = VacancyItem::class.java.name
    }