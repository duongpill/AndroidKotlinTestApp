package com.duongnh.beertestdemo.data

import com.duongnh.domain.models.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.repository.IGetBeersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestGetBeerRepository: IGetBeersRepository {
    override suspend fun getBeers(params: BaseRequest): Flow<List<Beer>> = flow {
        val beers = mutableListOf<Beer>()
        beers.add(Beer(1, "Saigon", "Vip", "09/2007", "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.", "https://images.punkapi.com/v2/keg.png", 4.5f))
        emit(beers)
    }
}