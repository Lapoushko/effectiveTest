package com.lapoushko.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Salary(
    @Json(name = "full")
    val full: String? = null,
    @Json(name = "short")
    val short: String? = null
)