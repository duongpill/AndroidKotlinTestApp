package com.duongnh.domain.usecases

import com.duongnh.domain.models.BaseRequest
import com.duongnh.domain.models.Beer
import com.duongnh.domain.models.BeerRequest
import com.duongnh.domain.repository.IGetBeersRepository
import kotlinx.coroutines.flow.Flow

class GetBeersUseCase(private val getBeersRepository: IGetBeersRepository): BaseUseCase<BaseRequest, Flow<List<Beer>>> {
    override suspend fun invoke(params: BaseRequest) = getBeersRepository.getBeers(params)
}