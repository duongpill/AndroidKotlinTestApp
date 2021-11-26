package com.duongnh.beertestdemo.domain

import com.duongnh.beertestdemo.data.FakeTestGetBeersRepository
import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.usecases.IGetBeersUseCase

class FakeGetBeersUseCase(private val getBeersRepository: FakeTestGetBeersRepository): IGetBeersUseCase {
    override suspend fun invoke(params: BaseRequest) = getBeersRepository.getBeers(params)
}