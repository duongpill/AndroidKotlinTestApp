package com.duongnh.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class BeerResponse(
    val id: Int,
    val name: String,
    val tagline: String,
    @Json(name = "first_brewed") val firstBrewed: String,
    val description: String,
    @Json(name = "image_url")  val imageUrl: String,
    val abv: String
)