package com.duongnh.data.mappers

import com.duongnh.data.models.BeerResponse
import com.duongnh.domain.models.Beer

internal fun BeerResponse.toDomain(): Beer {
    return Beer(this.id, this.name, this.tagline, this.firstBrewed, this.description, this.imageUrl, this.abv)
}