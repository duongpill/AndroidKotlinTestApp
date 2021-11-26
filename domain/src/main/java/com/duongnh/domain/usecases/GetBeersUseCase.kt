package com.duongnh.domain.usecases

import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.repository.IGetBeersRepository

class GetBeersUseCase(private val getBeersRepository: IGetBeersRepository): IGetBeersUseCase {
    override suspend fun invoke(params: BaseRequest) = getBeersRepository.getBeers(params)
}