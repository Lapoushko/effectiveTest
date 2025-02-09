package com.lapoushko.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Experience(
    @Json(name = "previewText")
    val previewText: String? = null,
    @Json(name = "text")
    val text: String? = null
)