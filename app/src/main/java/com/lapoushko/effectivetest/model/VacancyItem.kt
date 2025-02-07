package com.lapoushko.effectivetest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
@Serializable
@Parcelize
data class VacancyItem(
    val id: String,
    val lookingNumber: String,
    val title: String,
    val address: AddressItem,
    val company: String,
    val experience: ExperienceItem,
    val publishDate: String,
    val salary: String,
) : Parcelable