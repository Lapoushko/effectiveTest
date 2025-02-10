package com.lapoushko.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    @Json(name = "offers")
    val offerResponses: List<OfferResponse?>? = null,
    @Json(name = "vacancies")
    val vacancies: List<VacancyResponse?>? = null
)