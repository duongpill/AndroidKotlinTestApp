package com.duongnh.data.api

import com.duongnh.data.models.BeerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerService {
    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int, @Query("per_page") perPage: Int): Response<List<BeerResponse>>
}