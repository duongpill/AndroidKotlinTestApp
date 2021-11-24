package com.duongnh.beertestdemo.domain

import com.duongnh.domain.models.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.repository.IGetBeersRepository
import com.duongnh.domain.usecases.BaseUseCase
import kotlinx.coroutines.flow.Flow

class TestGetBeerUseCase(private val testGetBeerRepository: IGetBeersRepository): BaseUseCase<BaseRequest, Flow<List<Beer>>> {
    override suspend fun invoke(params: BaseRequest): Flow<List<Beer>> = testGetBeerRepository.getBeers(params)
}