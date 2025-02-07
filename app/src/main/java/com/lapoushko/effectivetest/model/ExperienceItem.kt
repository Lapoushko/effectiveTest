package com.lapoushko.effectivetest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
@Serializable
@Parcelize
data class ExperienceItem(
    val previewText: String,
    val text: String
) : Parcelable