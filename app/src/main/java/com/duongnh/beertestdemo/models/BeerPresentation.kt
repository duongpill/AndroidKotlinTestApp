package com.duongnh.beertestdemo.models

import com.duongnh.beertestdemo.base.adapter.BaseObject
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeerPresentation(override val id: Int,
                            val name: String,
                            val tagline: String,
                            val firstBrewed: String,
                            val description: String,
                            val imageUrl: String,
                            val abv: Float): BaseObject()