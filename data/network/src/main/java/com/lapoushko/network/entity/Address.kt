package com.lapoushko.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    @Json(name = "house")
    val house: String? = null,
    @Json(name = "street")
    val street: String? = null,
    @Json(name = "town")
    val town: String? = null
)