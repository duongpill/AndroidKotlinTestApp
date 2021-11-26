package com.duongnh.data.repository

import com.duongnh.data.IRetrofitClient
import com.duongnh.data.api.BeerService
import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.models.BeerRequest
import com.duongnh.domain.repository.IGetBeersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetBeersRepository(
    private val retrofitClient: IRetrofitClient
): IGetBeersRepository {
    override suspend fun getBeers(params: BaseRequest): Flow<List<Beer>> = flow {
        val beerService = retrofitClient.createService(BeerService::class.java)
        val beers = mutableListOf<Beer>()
        if(params is BeerRequest) {
            val beersResponse = beerService.getBeers(params.page, params.perPage)
            beersResponse.body()?.let { beers.addAll(it) }
        }
        emit(beers)
    }
}