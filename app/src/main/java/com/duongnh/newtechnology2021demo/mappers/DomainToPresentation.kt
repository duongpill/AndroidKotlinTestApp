package com.duongnh.newtechnology2021demo.mappers

import com.duongnh.newtechnology2021demo.models.BeerPresentation
import com.duongnh.domain.models.Beer

internal fun Beer.toPresentation() = BeerPresentation(id, name, tagline, first_brewed, description, image_url, abv)