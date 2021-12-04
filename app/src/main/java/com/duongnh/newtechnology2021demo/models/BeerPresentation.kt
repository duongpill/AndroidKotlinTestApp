package com.duongnh.newtechnology2021demo.models

import com.duongnh.newtechnology2021demo.base.adapter.BaseObject
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeerPresentation(override val id: Int,
                            val name: String,
                            val tagline: String,
                            val firstBrewed: String,
                            val description: String,
                            val imageUrl: String,
                            val abv: Float): BaseObject()