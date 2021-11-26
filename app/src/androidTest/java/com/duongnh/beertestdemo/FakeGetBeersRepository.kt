package com.duongnh.beertestdemo

import com.duongnh.domain.models.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.repository.IGetBeersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetBeersRepository: IGetBeersRepository {
    override suspend fun getBeers(params: BaseRequest): Flow<List<Beer>> = flow {
        val beers = mutableListOf<Beer>()
        beers.add(Beer(1, "Ha", "abc", "14", "asd", "asd", 14f))
        emit(beers)
    }
}