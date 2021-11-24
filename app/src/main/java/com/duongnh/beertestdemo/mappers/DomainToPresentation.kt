package com.duongnh.beertestdemo.mappers

import com.duongnh.beertestdemo.models.BeerPresentation
import com.duongnh.domain.models.Beer

internal fun Beer.toPresentation() = BeerPresentation(id, name, tagline, first_brewed, description, image_url, abv)