package com.duongnh.newtechnology2021demo.ui.beer

import com.duongnh.newtechnology2021demo.models.BeerPresentation
import com.duongnh.newtechnology2021demo.models.Error

data class BeersViewState(val isLoading: Boolean,
                          val error: Error?,
                          val beers: List<BeerPresentation>?)