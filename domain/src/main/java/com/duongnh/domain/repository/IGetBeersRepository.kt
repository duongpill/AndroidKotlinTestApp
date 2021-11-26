package com.duongnh.domain.repository

import com.duongnh.domain.base.BaseRequest
import com.duongnh.domain.models.Beer
import kotlinx.coroutines.flow.Flow

interface IGetBeersRepository {
    suspend fun getBeers(params: BaseRequest): Flow<List<Beer>>
}