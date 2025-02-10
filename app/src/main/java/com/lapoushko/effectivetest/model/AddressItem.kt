package com.lapoushko.effectivetest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
@Serializable
@Parcelize
data class AddressItem(
    val town: String,
    val street: String,
    val house: String
) : Parcelable