package com.lapoushko.network.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VacancyResponse(
    @Json(name = "address")
    val address: Address? = null,
    @Json(name = "appliedNumber")
    val appliedNumber: Int? = null,
    @Json(name = "company")
    val company: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "experience")
    val experience: Experience? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "isFavorite")
    val isFavorite: Boolean? = null,
    @Json(name = "lookingNumber")
    val lookingNumber: Int? = null,
    @Json(name = "publishedDate")
    val publishedDate: String? = null,
    @Json(name = "questions")
    val questions: List<String?>? = null,
    @Json(name = "responsibilities")
    val responsibilities: String? = null,
    @Json(name = "salary")
    val salary: com.lapoushko.network.entity.Salary? = null,
    @Json(name = "schedules")
    val schedules: List<String?>? = null,
    @Json(name = "title")
    val title: String? = null
)