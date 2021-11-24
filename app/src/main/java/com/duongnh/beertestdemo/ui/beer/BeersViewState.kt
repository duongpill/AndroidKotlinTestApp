package com.duongnh.beertestdemo.ui.beer

import com.duongnh.beertestdemo.models.BeerPresentation
import com.duongnh.beertestdemo.models.Error

data class BeersViewState(val isLoading: Boolean,
                          val error: Error?,
                          val beers: List<BeerPresentation>?)