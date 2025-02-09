package com.lapoushko.data.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfferResponse(
    @Json(name = "button")
    val button: Button? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "link")
    val link: String? = null,
    @Json(name = "title")
    val title: String? = null
)